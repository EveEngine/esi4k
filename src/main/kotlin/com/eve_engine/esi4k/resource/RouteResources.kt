package com.eve_engine.esi4k.resource

import com.eve_engine.esi4k.Datasource
import com.eve_engine.esi4k.ESIClient
import com.eve_engine.esi4k.ESIResponse
import com.eve_engine.esi4k.Version

class RouteResources(client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun routeRaw(origin: Int, destination: Int, avoid: List<Int>? = null, connections: List<Int>? = null, flag: RouteFlag? = null): ESIResponse {
        return with(createRequest("/route/$origin/$destination")){
            avoid?.let { addQueryParam("avoid", avoid.joinToString(",")) }
            connections?.let { addQueryParam("connections", connections.joinToString(",")) }
            flag?.let { addQueryParam("flag", flag.toString().toLowerCase()) }
            execute()
        }
    }

    fun route(origin: Int, destination: Int, avoid: List<Int>? = null, connections: List<Int>? = null, flag: RouteFlag? = null): ReifyResult<List<Int>> {
        return route(routeRaw(origin, destination, avoid, connections, flag))
    }

    fun route(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

}

enum class RouteFlag {
    Shortest, Secure, Insecure
}