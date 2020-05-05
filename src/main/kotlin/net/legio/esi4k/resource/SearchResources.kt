package net.legio.esi4k.resource

import net.legio.esi4k.*
import net.legio.esi4k.model.SearchResult

class SearchResources (client: ESIClient, version: Version = Version.LATEST, datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client, version, datasource) {

    fun searchRaw(search: String, categories: List<EntityCategory>, language: AcceptLanguages = AcceptLanguages.EN_US, strict: Boolean = false, characterId: Int? = null): ESIResponse {
        val request = if(characterId != null) {
            createRequest("/characters/$characterId/search", authorization = true)
        }else {
            createRequest("/search")
        }
        return with(request){
            addQueryParam("search", search)
            addQueryParam("categories", categories.joinToString(separator = ",") { c -> c.value })
            addQueryParam("strict", strict.toString())
            addHeader(ESIHeader.ACCEPT_LANGUAGE, language.value)
            execute()
        }
    }

    fun search(search: String, categories: List<EntityCategory>, language: AcceptLanguages = AcceptLanguages.EN_US, strict: Boolean = false, characterId: Int? = null): ReifyResult<SearchResult> {
        return search(searchRaw(search, categories, language, strict, characterId))
    }

    fun search(esiResponse: ESIResponse): ReifyResult<SearchResult> {
        return responseToEntity(esiResponse)
    }


}

enum class EntityCategory(val value: String) {
    Agent("agent"),
    Alliance("alliance"),
    Character("character"),
    Constellation("constellation"),
    Corporation("corporation"),
    Faction("faction"),
    InventoryType("inventory_type"),
    Region("region"),
    SolarSystem("solar_system"),
    Station("station"),
    Structure("structure");
}