package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.CharacterOnline
import net.legio.esi4k.model.CharacterShip
import net.legio.esi4k.model.Location

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