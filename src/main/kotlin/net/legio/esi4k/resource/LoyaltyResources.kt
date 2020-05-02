package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.LoyaltyPoints
import net.legio.esi4k.model.LoyaltyStoreOffer

class LoyaltyResources (client: ESIClient, version: Version = Version.LATEST, datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client, version, datasource) {

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