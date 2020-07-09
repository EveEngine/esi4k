package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.Datasource
import com.eve.engine.esi4k.ESIClient
import com.eve.engine.esi4k.ESIResponse
import com.eve.engine.esi4k.Version
import com.eve.engine.esi4k.model.CharacterOnline
import com.eve.engine.esi4k.model.CharacterShip
import com.eve.engine.esi4k.model.Location

class LocationResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterLocationRaw(characterId: Int): ESIResponse{
        return callExecute("/characters/$characterId/location", authorization = true)
    }

    fun characterLocation(characterId: Int): ReifyResult<Location> {
        return characterLocation(characterLocationRaw(characterId))
    }

    fun characterLocation(esiResponse: ESIResponse): ReifyResult<Location> {
        return responseToEntity(esiResponse)
    }

    fun characterOnlineRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/online", authorization = true)
    }

    fun characterOnline(characterId: Int): ReifyResult<CharacterOnline> {
        return characterOnline(characterOnlineRaw(characterId))
    }

    fun characterOnline(esiResponse: ESIResponse): ReifyResult<CharacterOnline> {
        return responseToEntity(esiResponse)
    }

    fun characterShipRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/ship", authorization = true)
    }

    fun characterShip(characterId: Int): ReifyResult<CharacterShip> {
        return characterShip(characterShipRaw(characterId))
    }

    fun characterShip(esiResponse: ESIResponse): ReifyResult<CharacterShip>{
        return responseToEntity(esiResponse)
    }

}