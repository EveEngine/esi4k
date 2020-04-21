package net.legio.esi4k.resource

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.legio.esi4k.*
import net.legio.esi4k.model.Fitting
import net.legio.esi4k.model.FittingId

class FittingsResources(esiClient: ESIClient, version: Version, datasource: Datasource): ESIResources(esiClient, version, datasource) {

    fun characterFittingsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/fittings", authorization = true)
    }

    fun characterFittings(characterId: Int): ReifyResult<List<Fitting>> {
        return characterFittings(characterFittingsRaw(characterId))
    }

    fun characterFittings(esiResponse: ESIResponse): ReifyResult<List<Fitting>> {
        return responseToEntityList(esiResponse)
    }

    fun saveCharacterFittingRaw(characterId: Int, fitting: Fitting): ESIResponse {
        return with(createRequest("/characters/$characterId/fittings", HttpMethod.POST, true)){
            body = mapper.writeValueAsString(fitting)
            execute()
        }
    }

    fun saveCharacterFitting(characterId: Int, fitting: Fitting): ReifyResult<FittingId> {
        return saveCharacterFitting(saveCharacterFittingRaw(characterId, fitting))
    }

    fun saveCharacterFitting(esiResponse: ESIResponse): ReifyResult<FittingId> {
        return responseToEntity(esiResponse)
    }

    fun deleteCharacterFitting(characterId: Int, fittingId: Int): ESIResponse {
        return callExecute("/characters/$characterId/fittings/$fittingId", HttpMethod.DELETE, true)
    }
}