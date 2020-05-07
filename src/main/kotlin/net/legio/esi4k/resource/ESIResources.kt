package net.legio.esi4k.resource

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.type.TypeFactory
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import net.legio.esi4k.*

sealed class ReifyResult<T>
data class GoodReify<T>(val data: T?): ReifyResult<T>()
data class FailedReify<T>(val error: String): ReifyResult<T>()
data class NoReify<T>(val message: String): ReifyResult<T>()

/**
 * Base resources class with reification functions to deserialize the raw content.
 */
abstract class ESIResources(var client: ESIClient, var version: Version, var datasource: Datasource) {
    val mapper = jacksonObjectMapper().apply {
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
    }

    protected fun callExecute(endpoint: String, httpMethod: HttpMethod = HttpMethod.GET, authorization: Boolean = false, body: String? = null): ESIResponse {
        return client.createESIRequest("/${version.value}/${endpoint}", httpMethod).apply {
            addQueryParam("datasource", datasource.value)
            if(authorization){
                client.accessToken?.let {
                    addHeader(ESIHeader.AUTHORIZATION, it)
                }
            }
            this.body = body
        }.execute()
    }

    protected fun createRequest(endpoint: String, httpMethod: HttpMethod = HttpMethod.GET, authorization: Boolean = false, body: String? = null): ESIRequest {
        return client.createESIRequest("/${version.value}/${endpoint}", httpMethod).apply {
            addQueryParam("datasource", datasource.value)
            if (authorization) {
                client.accessToken?.let {
                    addHeader(ESIHeader.AUTHORIZATION, "Bearer $it")
                }
            }
            this.body = body
        }
    }

    inline fun <reified T> responseToEntity(esiResponse: ESIResponse): ReifyResult<T>{
        return when(esiResponse){
            is ESISuccessResponse -> reifyContent(esiResponse.content)
            is ESIFailResponse -> NoReify("ESI call failed: [${esiResponse.code}] ${esiResponse.errorMessage}")
        }
    }

    inline fun <reified T> responseToEntityList(esiResponse: ESIResponse): ReifyResult<List<T>>{
        return when(esiResponse){
            is ESISuccessResponse -> reifyContentAsList(esiResponse.content)
            is ESIFailResponse -> NoReify("ESI call failed: [${esiResponse.code}] ${esiResponse.errorMessage}")
        }
    }

    /**
     * Attempts to reify the content string as a list of type parameter.
     */
    inline fun <reified T> reifyContentAsList(content: String): ReifyResult<List<T>> {
        return try {
            GoodReify(mapper.readValue(content, TypeFactory.defaultInstance().constructCollectionType(List::class.java, T::class.java)))
        }catch(e: Exception){
            FailedReify("${e.message}")
        }
    }

    /**
     * Attempts to reify the content string as a single entity.
     */
    inline fun <reified T> reifyContent(content: String): ReifyResult<T>{
        return try{
            GoodReify(jacksonObjectMapper().readValue(content, jacksonTypeRef<T>()))
        }catch (e:Exception){
            FailedReify("${e.message}")
        }
    }

}