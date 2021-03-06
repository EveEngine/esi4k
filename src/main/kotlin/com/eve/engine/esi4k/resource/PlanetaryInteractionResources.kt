package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.Datasource
import com.eve.engine.esi4k.ESIClient
import com.eve.engine.esi4k.ESIResponse
import com.eve.engine.esi4k.Version
import com.eve.engine.esi4k.model.Colony
import com.eve.engine.esi4k.model.ColonyLayout
import com.eve.engine.esi4k.model.CustomsOffice
import com.eve.engine.esi4k.model.Schematic

class PlanetaryInteractionResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterPlanetColoniesRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/planets", authorization = true)
    }

    fun characterPlanetColonies(characterId: Int): ReifyResult<List<Colony>> {
        return characterPlanetColonies(characterPlanetColoniesRaw(characterId))
    }

    fun characterPlanetColonies(esiResponse: ESIResponse): ReifyResult<List<Colony>> {
        return responseToEntityList(esiResponse)
    }

    fun characterPlanetColonyLayoutRaw(characterId: Int, planetId: Int): ESIResponse {
        return callExecute("/characters/$characterId/planets/$planetId", authorization = true)
    }

    fun characterPlanetColonyLayout(characterId: Int, planetId: Int): ReifyResult<List<ColonyLayout>> {
        return characterPlanetColonyLayout(characterPlanetColonyLayoutRaw(characterId, planetId))
    }

    fun characterPlanetColonyLayout(esiResponse: ESIResponse): ReifyResult<List<ColonyLayout>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationCustomsOfficesRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/customs_offices", authorization = true)) {
            this.page = page
            execute()
        }
    }

    fun corporationCustomsOffices(corporationId: Int, page: Int = 1): ReifyResult<List<CustomsOffice>> {
        return corporationCustomsOffices(corporationCustomsOfficesRaw(corporationId, page))
    }

    fun corporationCustomsOffices(esiResponse: ESIResponse): ReifyResult<List<CustomsOffice>> {
        return responseToEntityList(esiResponse)
    }

    fun schematicRaw(schematicId: Int): ESIResponse {
        return callExecute("/universe/schematics/$schematicId")
    }

    fun schematic(schematicId: Int): ReifyResult<Schematic> {
        return schematic(schematicRaw(schematicId))
    }

    fun schematic(esiResponse: ESIResponse): ReifyResult<Schematic> {
        return responseToEntity(esiResponse)
    }

}