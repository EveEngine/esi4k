package net.legio.esi4k

import org.apache.http.Header
import org.apache.http.client.methods.CloseableHttpResponse

sealed class ESIResponse(response: CloseableHttpResponse){
    val code: Int = response.statusLine.statusCode
    val content: String = response.entity.content.readAllBytes().toString(kotlin.text.Charsets.UTF_8)
    val headers: Array<Header> = response.allHeaders

    companion object {

        @JvmStatic
        internal fun createFrom(response: CloseableHttpResponse): ESIResponse {
            return when (response.statusLine.statusCode) {
                in 200..299 -> {
                    ESISuccessResponse(response)
                }
                in 300..399 -> {
                    ESISuccessResponse(response)
                    //TODO What do 300-399 mean for a response? Return the cache once it's implemented? For now returning success.
                }
                else -> {
                    ESIFailResponse(response)
                }
            }
        }
    }
}

class ESISuccessResponse internal constructor (response: CloseableHttpResponse): ESIResponse(response)

class ESIFailResponse internal constructor (response: CloseableHttpResponse): ESIResponse(response){
    val errorMessage: String = response.statusLine.reasonPhrase
}