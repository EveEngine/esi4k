package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version

class RouteResources(client: ESIClient, version: Version = Version.LATEST, datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client, version, datasource) {

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