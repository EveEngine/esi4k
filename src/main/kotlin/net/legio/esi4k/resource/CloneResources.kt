package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.CloneInformation

class CloneResources(esiClient: ESIClient, version: Version, datasource: Datasource): ESIResources(esiClient, version, datasource) {

    fun characterClonesRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/clones", authorization = true)
    }

    fun characterClones(characterId: Int): ReifyResult<CloneInformation> {
        return characterClones(characterClonesRaw(characterId))
    }

    fun characterClones(esiResponse: ESIResponse): ReifyResult<CloneInformation> {
        return responseToEntity(esiResponse)
    }

    fun characterImplantsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/implants", authorization = true)
    }

    fun characterImplants(characterId: Int): ReifyResult<List<Int>> {
        return characterImplants(characterImplantsRaw(characterId))
    }

    fun characterImplants(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }
}