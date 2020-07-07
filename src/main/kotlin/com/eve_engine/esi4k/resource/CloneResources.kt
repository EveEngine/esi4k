package com.eve_engine.esi4k.resource

import com.eve_engine.esi4k.Datasource
import com.eve_engine.esi4k.ESIClient
import com.eve_engine.esi4k.ESIResponse
import com.eve_engine.esi4k.Version
import com.eve_engine.esi4k.model.CloneInformation

class CloneResources(esiClient: ESIClient,  datasource: Datasource): ESIResources(esiClient,  datasource) {

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