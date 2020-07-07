package com.eve_engine.esi4k

import com.fasterxml.jackson.databind.type.TypeFactory
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.eve_engine.esi4k.model.ESIStatus
import com.eve_engine.esi4k.model.RouteStatus
import com.eve_engine.esi4k.resource.FailedReify
import com.eve_engine.esi4k.resource.GoodReify
import com.eve_engine.esi4k.resource.ReifyResult
import org.apache.http.client.methods.*
import org.apache.http.client.utils.URIBuilder
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder

class ESIClient {
    /**
     * The access token used for resources requiring permissions.
     */
    var accessToken: String? = null
    var clientId: String? = null

    /**
     * Sets the User-Agent header with the set client ID. If the client ID is not set, then this is ignored all together.
     */
    var applyUserAgentPerRequest: Boolean = false

    /**
     * Attempts to ping the ESI server's ping meta endpoint.
     */
    fun ping(): Boolean{
        return when(createESIRequest("/ping").execute()){
            is ESISuccessResponse -> true
            is ESIFailResponse -> false
        }
    }

    /**
     * Calls on the /verify meta endpoint to verify and validate the access token. Any fail response will result in
     * a [TokenInvalid]. Otherwise, success will yield [TokenVerified].
     */
    fun verifyAuthentication(): TokenVerify?{
        if(accessToken.isNullOrBlank()) return null
        val request = ESIRequest(this, endpoint = "/verify")
        request.addHeader(ESIHeader.AUTHORIZATION,"Bearer $accessToken!!")
        if(applyUserAgentPerRequest) {
            clientId?.let {
                request.addHeader(ESIHeader.X_USER_AGENT,it)
            }
        }
        return TokenVerify.verify(request.execute())
    }

    internal fun execute(esiRequest: ESIRequest): ESIResponse{
        val client = HttpClientBuilder.create().build()
        val request = createHttpRequest(esiRequest)
        return ESIResponse.createFrom(client.execute(request))
    }

    /** Generates an [ESIRequest] with the given parameters */
    fun createESIRequest(endpoint: String? = null, method: HttpMethod = HttpMethod.GET): ESIRequest{
        return ESIRequest(this).apply {
            this.endpoint = endpoint
            this.method = method
        }
    }

    private fun createHttpRequest(esiRequest: ESIRequest): HttpRequestBase {
        val uri = createUri(esiRequest.endpoint?:"/", esiRequest.params())
        val request = when(esiRequest.method){
            HttpMethod.GET -> HttpGet(uri)
            HttpMethod.POST -> HttpPost(uri).apply { entity = StringEntity(esiRequest.body) }
            HttpMethod.PUT -> HttpPut(uri).apply { entity = StringEntity(esiRequest.body) }
            HttpMethod.DELETE -> HttpDelete(uri)
        }
        esiRequest.headers().forEach { h -> request.addHeader(h.key, h.value)}
        return request
    }

    /**
     * Constructs a URI with the given endpoint and parameters.
     *
     * @param endpoint The endpoint to concat the parameters to.
     * @param params List of parameter pairs: parameter name and the list of values.
     */
    private fun createUri(endpoint: String,params: List<Pair<String, Set<String>>> = arrayListOf()): String {
        val builder = URIBuilder(ESI_HOST).setPath(endpoint)
        params.forEach { param ->
            param.second.forEach {  value ->
                builder.addParameter(param.first, value)
            }
        }
        return builder.build().toString()
    }

    /**
     * Retrieves the health and status of latest version of ESI routes.
     *
     * @param onlyBad if true, will only return the statuses that are [RouteStatus.Red]
     */
    fun esiStatus(onlyBad: Boolean = false): ReifyResult<List<ESIStatus>> {
        val response = execute(createESIRequest("/status.json"))
        return if(response is ESISuccessResponse){
            val statuses: List<ESIStatus>? = jacksonObjectMapper().readValue(response.content, TypeFactory.defaultInstance().constructCollectionType(List::class.java, ESIStatus::class.java))
            if(onlyBad){
                return GoodReify(statuses?.filter { s -> s.status == RouteStatus.Red })
            }
            GoodReify(statuses)
        }else {
            FailedReify((response as ESIFailResponse).errorMessage)
        }
    }

    companion object {
        const val ESI_HOST = "https://esi.evetech.net"
    }

}