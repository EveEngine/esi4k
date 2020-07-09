package com.eve.engine.esi4k

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class ESIRequest(val client: ESIClient, var method: HttpMethod = HttpMethod.GET, var endpoint: String? = null) {
    private val headers: MutableMap<ESIHeader, String> = EnumMap(ESIHeader::class.java)
    private val queryParams: MutableMap<String, MutableSet<String>> = HashMap()
    var body: String? = null
    var page: Int = 0

    fun addHeader(header: ESIHeader, value: String) {
        headers[header] = value
    }

    fun removeHeader(header: ESIHeader): String? {
        return headers.remove(header)
    }

    fun headers(): Map<String, String> {
        return headers.map { e -> e.key.value to e.value }.toMap()
    }

    fun clearHeaders() = headers.clear()

    fun addQueryParam(key: String, value: String){
        queryParams.getOrPut(key, {HashSet()}).apply {
            if(!contains(value)){
                add(value)
            }
        }
    }

    fun removeQueryParam(key: String, value: String){
        queryParams[key]?.remove(value)
    }

    fun removeQueryParam(key: String) {
        queryParams.remove(key)
    }

    fun params(): List<Pair<String, Set<String>>> {
        if(page > 0) addQueryParam("page", page.toString())
        queryParams.map { e -> Pair(e.key, e.value) }
        return queryParams.map { e -> Pair(e.key, e.value) }
    }

    fun execute(): ESIResponse {
        return client.execute(this)
    }
}

enum class HttpMethod {
    GET, POST, PUT, DELETE
}