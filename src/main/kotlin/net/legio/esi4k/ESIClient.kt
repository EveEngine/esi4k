package net.legio.esi4k

import org.apache.http.client.methods.*
import org.apache.http.client.utils.URIBuilder
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder

class ESIClient {
    var accessToken: String? = null
    var clientId: String? = null
    var applyUserAgentPerRequest: Boolean = false

    fun ping(): Boolean{
        return when(createESIRequest(PING_EP).execute()){
            is ESISuccessResponse -> true
            is ESIFailResponse -> false
        }
    }

    /**
     * Calls on the /verify endpoint to verify and validate the access token.
     * @return
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

    companion object {
        const val ESI_HOST = "https://esi.evetech.net"
        const val PING_EP = "ping"
    }

}