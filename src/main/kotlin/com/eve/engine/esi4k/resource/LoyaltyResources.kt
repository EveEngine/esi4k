package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.Datasource
import com.eve.engine.esi4k.ESIClient
import com.eve.engine.esi4k.ESIResponse
import com.eve.engine.esi4k.Version
import com.eve.engine.esi4k.model.LoyaltyPoints
import com.eve.engine.esi4k.model.LoyaltyStoreOffer

class LoyaltyResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterLoyaltyPointsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/loyalty/points", authorization = true)
    }

    fun characterLoyaltyPoints(characterId: Int): ReifyResult<List<LoyaltyPoints>> {
        return characterLoyaltyPoints(characterLoyaltyPointsRaw(characterId))
    }

    fun characterLoyaltyPoints(esiResponse: ESIResponse): ReifyResult<List<LoyaltyPoints>> {
        return responseToEntityList(esiResponse)
    }

    fun loyaltyStoreOffersRaw(corporationId: Int): ESIResponse {
        return callExecute("/loyalty/stores/$corporationId/offers")
    }

    fun loyaltyStoreOffer(corporationId: Int): ReifyResult<List<LoyaltyStoreOffer>> {
        return loyaltyStoreOffer(loyaltyStoreOffersRaw(corporationId))
    }

    fun loyaltyStoreOffer(esiResponse: ESIResponse): ReifyResult<List<LoyaltyStoreOffer>> {
        return responseToEntityList(esiResponse)
    }

}