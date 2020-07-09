package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.*
import com.eve.engine.esi4k.model.Alliance
import com.eve.engine.esi4k.model.Icons

class AllianceResources(client: ESIClient, datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun alliancesIdsRaw(): ESIResponse{
        return callExecute("/alliances")
    }

    fun alliancesIds(): ReifyResult<List<Int>>{
        return alliancesIds(alliancesIdsRaw())
    }

    fun alliancesIds(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun allianceRaw(allianceId: Int): ESIResponse {
        return callExecute("alliances/$allianceId")
    }

    fun alliance(allianceId: Int): ReifyResult<Alliance> {
        return alliance(allianceRaw(allianceId))
    }

    fun alliance(esiResponse: ESIResponse): ReifyResult<Alliance> {
        return responseToEntity(esiResponse)
    }

    fun allianceCorporationIdsRaw(allianceId: Int): ESIResponse {
        return callExecute("/alliances/$allianceId/corporations")
    }

    fun allianceCorporationIds(allianceId: Int): ReifyResult<List<Int>> {
        return allianceCorporationIds(allianceCorporationIdsRaw(allianceId))
    }

    fun allianceCorporationIds(esiResponse: ESIResponse): ReifyResult<List<Int>>{
        return responseToEntityList(esiResponse)
    }

    fun allianceIconsRaw(allianceId: Int): ESIResponse {
        return callExecute("/alliances/$allianceId/icons")
    }

    fun allianceIcons(allianceId: Int): ReifyResult<Icons>{
        return allianceIcons(allianceIconsRaw(allianceId))
    }

    fun allianceIcons(esiResponse: ESIResponse): ReifyResult<Icons> {
        return responseToEntity(esiResponse)
    }

}