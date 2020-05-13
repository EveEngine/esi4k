package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.SovereigntyCampaign
import net.legio.esi4k.model.SovereigntyInformation
import net.legio.esi4k.model.SovereigntyStructure

class SovereigntyResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun sovereigntyCampaignsRaw(): ESIResponse {
        return callExecute("/sovereignty/campaigns")
    }

    fun sovereigntyCampaigns(): ReifyResult<List<SovereigntyCampaign>> {
        return sovereigntyCampaigns(sovereigntyCampaignsRaw())
    }

    fun sovereigntyCampaigns(esiResponse: ESIResponse): ReifyResult<List<SovereigntyCampaign>> {
        return responseToEntityList(esiResponse)
    }

    fun sovereigntyMapRaw(): ESIResponse {
        return callExecute("/sovereignty/map")
    }

    fun sovereigntyMap(): ReifyResult<List<SovereigntyInformation>> {
        return sovereigntyMap(sovereigntyMapRaw())
    }

    fun sovereigntyMap(esiResponse: ESIResponse): ReifyResult<List<SovereigntyInformation>> {
        return responseToEntityList(esiResponse)
    }

    fun sovereigntyStructuresRaw(): ESIResponse {
        return callExecute("/sovereignty/structures")
    }

    fun sovereigntyStructures(): ReifyResult<List<SovereigntyStructure>>{
        return sovereigntyStructures(sovereigntyStructuresRaw())
    }

    fun sovereigntyStructures(esiResponse: ESIResponse): ReifyResult<List<SovereigntyStructure>> {
        return responseToEntityList(esiResponse)
    }

}