package com.eve_engine.esi4k.resource

import com.eve_engine.esi4k.Datasource
import com.eve_engine.esi4k.ESIClient
import com.eve_engine.esi4k.ESIResponse
import com.eve_engine.esi4k.Version
import com.eve_engine.esi4k.model.Incursion

class IncursionResources(esiClient: ESIClient,  datasource: Datasource): ESIResources(esiClient,  datasource) {

    fun incursionsRaw(): ESIResponse {
        return callExecute("/incursions")
    }

    fun incursions(): ReifyResult<List<Incursion>> {
        return incursions(incursionsRaw())
    }

    fun incursions(esiResponse: ESIResponse): ReifyResult<List<Incursion>> {
        return responseToEntity(esiResponse)
    }

}