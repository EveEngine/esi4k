package com.eve_engine.esi4k.resource

import com.eve_engine.esi4k.*
import com.eve_engine.esi4k.model.*

class UniverseResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun ancestriesRaw(acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/ancestries")) {
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun ancestries(acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<List<Ancestry>> {
        return ancestries(ancestriesRaw(acceptLanguages))
    }

    fun ancestries(esiResponse: ESIResponse): ReifyResult<List<Ancestry>> {
        return responseToEntityList(esiResponse)
    }

    fun asteroidBeltRaw(asteroidBeltId: Int): ESIResponse {
        return callExecute("/universe/asteroid_belts/$asteroidBeltId")
    }

    fun asteroidBelt(asteroidBeltId: Int): ReifyResult<AsteroidBelt> {
        return asteroidBelt(asteroidBeltRaw(asteroidBeltId))
    }

    fun asteroidBelt(esiResponse: ESIResponse): ReifyResult<AsteroidBelt> {
        return responseToEntity(esiResponse)
    }

    fun bloodlinesRaw(acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/bloodlines")){
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun bloodlines(acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<List<Bloodline>> {
        return bloodlines(bloodlinesRaw(acceptLanguages))
    }

    fun bloodlines(esiResponse: ESIResponse): ReifyResult<List<Bloodline>> {
        return responseToEntityList(esiResponse)
    }

    fun categoriesRaw(): ESIResponse {
        return callExecute("/universe/categories")
    }

    fun categories(): ReifyResult<List<Int>> {
        return categories(categoriesRaw())
    }

    fun categories(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun categoryRaw(categoryId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/categories/$categoryId")) {
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun category(categoryId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<Category> {
        return category(categoryRaw(categoryId, acceptLanguages))
    }

    fun category(esiResponse: ESIResponse): ReifyResult<Category> {
        return responseToEntity(esiResponse)
    }

    fun constellationsRaw(): ESIResponse {
        return callExecute("/universe/constellations")
    }

    fun constellations(): ReifyResult<List<Int>> {
        return constellations(constellationsRaw())
    }

    fun constellations(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun constellationRaw(constellationId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/categories/$constellationId")) {
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun constellation(constellationId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<Constellation> {
        return constellation(constellationRaw(constellationId, acceptLanguages))
    }

    fun constellation(esiResponse: ESIResponse): ReifyResult<Constellation> {
        return responseToEntity(esiResponse)
    }

    fun factionsRaw(acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/factions")) {
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun factions(acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<List<Faction>> {
        return factions(factionsRaw(acceptLanguages))
    }

    fun factions(esiResponse: ESIResponse): ReifyResult<List<Faction>> {
        return responseToEntityList(esiResponse)
    }

    fun graphicsRaw(): ESIResponse {
        return callExecute("/universe/graphics")
    }

    fun graphics(): ReifyResult<List<Int>> {
        return graphics(graphicsRaw())
    }

    fun graphics(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun graphicRaw(graphicId: Int): ESIResponse {
        return callExecute("/universe/graphics/$graphicId")
    }

    fun graphic(graphicId: Int): ReifyResult<List<Graphic>> {
        return graphic(graphicRaw(graphicId))
    }

    fun graphic(esiResponse: ESIResponse): ReifyResult<List<Graphic>> {
        return responseToEntityList(esiResponse)
    }

    fun groupsRaw(page: Int = 1): ESIResponse {
        return with(createRequest("/universe/groups")){
            this.page = page
            execute()
        }
    }

    fun groups(page: Int = 1): ReifyResult<List<Int>> {
        return groups(groupsRaw(page))
    }

    fun groups(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun groupRaw(groupId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/groups/$groupId")) {
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun group(groupId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<ItemGroup> {
        return group(groupRaw(groupId, acceptLanguages))
    }

    fun group(esiResponse: ESIResponse): ReifyResult<ItemGroup> {
        return responseToEntity(esiResponse)
    }

    fun namesToIdsRaw(names: List<String>, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/ids", HttpMethod.POST)) {
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            body = names.joinToString(",")
            execute()
        }
    }

    fun namesToIds(names: List<String>, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<NameToIdResult> {
        return namesToIds(namesToIdsRaw(names, acceptLanguages))
    }

    fun namesToIds(esiResponse: ESIResponse): ReifyResult<NameToIdResult> {
        return responseToEntity(esiResponse)
    }

    fun moonRaw(moonId: Int): ESIResponse {
        return callExecute("/universe/moons/$moonId")
    }

    fun moon(moonId: Int): ReifyResult<Moon> {
        return moon(moonRaw(moonId))
    }

    fun moon(esiResponse: ESIResponse): ReifyResult<Moon> {
        return responseToEntity(esiResponse)
    }

    fun idsToNamesRaw(ids: List<Int>): ESIResponse {
        return with(createRequest("/universe/names", HttpMethod.POST)){
            body = ids.joinToString(",")
            execute()
        }
    }

    fun idsToNames(ids: List<Int>): ReifyResult<List<IdToNameResult>> {
        return idsToNames(idsToNamesRaw(ids))
    }

    fun idsToNames(esiResponse: ESIResponse): ReifyResult<List<IdToNameResult>> {
        return responseToEntityList(esiResponse)
    }

    fun planetRaw(planetId: Int): ESIResponse {
        return callExecute("/universe/planets/$planetId")
    }

    fun planet(planetId: Int): ReifyResult<Planet> {
        return planet(planetRaw(planetId))
    }

    fun planet(esiResponse: ESIResponse): ReifyResult<Planet> {
        return responseToEntity(esiResponse)
    }

    fun raceRaw(acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US) : ESIResponse {
        return with(createRequest("/universe/races", HttpMethod.POST)) {
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun race(acceptLanguages: AcceptLanguages): ReifyResult<List<Race>> {
        return race(raceRaw(acceptLanguages))
    }

    fun race(esiResponse: ESIResponse): ReifyResult<List<Race>> {
        return responseToEntity(esiResponse)
    }

    fun regionsRaw(): ESIResponse {
        return callExecute("/universe/regions")
    }

    fun regions(): ReifyResult<List<Int>> {
        return regions(regionsRaw())
    }

    fun regions(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun regionRaw(regionId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/regions/$regionId")){
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun region(regionId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<Region> {
        return region(regionRaw(regionId, acceptLanguages))
    }

    fun region(esiResponse: ESIResponse): ReifyResult<Region> {
        return responseToEntity(esiResponse)
    }

    fun stargateRaw(stargateId: Int): ESIResponse {
        return callExecute("/universe/stargate/$stargateId")
    }

    fun stargate(stargateId: Int): ReifyResult<Stargate> {
        return stargate(stargateRaw(stargateId))
    }

    fun stargate(esiResponse: ESIResponse): ReifyResult<Stargate> {
        return responseToEntity(esiResponse)
    }

    fun starRaw(starId: Int): ESIResponse {
        return callExecute("/universe/star/$starId")
    }

    fun star(starId: Int): ReifyResult<Star> {
        return star(starRaw(starId))
    }

    fun star(esiResponse: ESIResponse): ReifyResult<Star> {
        return responseToEntity(esiResponse)
    }

    fun stationRaw(stationId: Int): ESIResponse {
        return callExecute("/universe/stations/$stationId")
    }

    fun station(stationId: Int): ReifyResult<Station> {
        return station(stationRaw(stationId))
    }

    fun station(esiResponse: ESIResponse): ReifyResult<Station> {
        return responseToEntity(esiResponse)
    }

    fun structuresRaw(): ESIResponse {
        return callExecute("/universe/structures")
    }

    fun structures(): ReifyResult<List<Long>> {
        return structures(structuresRaw())
    }

    fun structures(esiResponse: ESIResponse): ReifyResult<List<Long>> {
        return responseToEntityList(esiResponse)
    }

    fun structureRaw(structureId: Int): ESIResponse {
        return callExecute("/universe/structures/$structureId", authorization = true)
    }

    fun structure(structureId: Int): ReifyResult<Structure> {
        return structure(structureRaw(structureId))
    }

    fun structure(esiResponse: ESIResponse): ReifyResult<Structure> {
        return responseToEntity(esiResponse)
    }

    fun systemJumpsRaw(): ESIResponse {
        return callExecute("/universe/system_jumps")
    }

    fun systemJumps(): ReifyResult<List<SystemJumps>> {
        return systemJumps(systemJumpsRaw())
    }

    fun systemJumps(esiResponse: ESIResponse): ReifyResult<List<SystemJumps>> {
        return responseToEntityList(esiResponse)
    }

    fun systemKillsRaw(): ESIResponse {
        return callExecute("/universe/system_kills")
    }

    fun systemKills(): ReifyResult<List<SystemKills>> {
        return systemKills(systemKillsRaw())
    }

    fun systemKills(esiResponse: ESIResponse): ReifyResult<List<SystemKills>> {
        return responseToEntityList(esiResponse)
    }

    fun systemsRaw(): ESIResponse {
        return callExecute("/universe/systems")
    }

    fun systems(): ReifyResult<List<Int>> {
        return systems(systemsRaw())
    }

    fun systems(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun systemRaw(systemId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/systems/$systemId")){
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun system(systemId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<SolarSystem> {
        return system(systemRaw(systemId, acceptLanguages))
    }

    fun system(esiResponse: ESIResponse): ReifyResult<SolarSystem> {
        return responseToEntity(esiResponse)
    }

    fun typesRaw(page: Int = 1): ESIResponse {
        return with(createRequest("/universe/types")){
            this.page = page
            execute()
        }
    }

    fun types(page: Int = 1): ReifyResult<List<Int>> {
        return types(typesRaw(page))
    }

    fun types(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun typeRaw(typeId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/universe/types/$typeId")){
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun type(typeId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<Type> {
        return type(typeRaw(typeId, acceptLanguages))
    }

    fun type(esiResponse: ESIResponse): ReifyResult<Type> {
        return responseToEntity(esiResponse)
    }

}