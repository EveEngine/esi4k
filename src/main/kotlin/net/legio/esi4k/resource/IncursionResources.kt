package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.Incursion

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