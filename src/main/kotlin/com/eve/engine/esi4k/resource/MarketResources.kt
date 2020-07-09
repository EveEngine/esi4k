package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.*
import com.eve.engine.esi4k.model.*

class MarketResources(client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterOrdersRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/orders", authorization = true)
    }

    fun characterOrders(characterId: Int): ReifyResult<List<CharacterMarketOrder>> {
        return characterOrders(characterOrdersRaw(characterId))
    }

    fun characterOrders(esiResponse: ESIResponse): ReifyResult<List<CharacterMarketOrder>> {
        return responseToEntityList(esiResponse)
    }

    fun characterOrderHistoryRaw(characterId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/characters/$characterId/orders/history", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun characterOrderHistory(characterId: Int, page: Int = 1): ReifyResult<List<CharacterOrderHistory>> {
        return characterOrderHistory(characterOrderHistoryRaw(characterId, page))
    }

    fun characterOrderHistory(esiResponse: ESIResponse): ReifyResult<List<CharacterOrderHistory>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationOrdersRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/orders", authorization = true)) {
            this.page = page
            execute()
        }

    }

    fun corporationOrders(corporationId: Int, page: Int = 1): ReifyResult<List<CorporationMarketOrder>> {
        return corporationOrders(corporationOrdersRaw(corporationId, page))
    }

    fun corporationOrders(esiResponse: ESIResponse): ReifyResult<List<CorporationMarketOrder>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationOrderHistoryRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/orders/history", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationOrderHistory(corporationId: Int, page: Int = 1): ReifyResult<List<CorporationMarketOrderHistory>> {
        return corporationOrderHistory(corporationOrderHistoryRaw(corporationId, page))
    }

    fun corporationOrderHistory(esiResponse: ESIResponse): ReifyResult<List<CorporationMarketOrderHistory>> {
        return responseToEntityList(esiResponse)
    }

    fun regionMarketHistoryRaw(regionId: Int, typeId: Int): ESIResponse {
        return with(createRequest("/markets/$regionId/history")){
            addQueryParam("type_id", typeId.toString())
            execute()
        }
    }

    fun regionMarketHistory(regionId: Int, typeId: Int): ReifyResult<List<TypeMarketStatistic>> {
        return regionMarketHistory(regionMarketHistoryRaw(regionId, typeId))
    }

    fun regionMarketHistory(esiResponse: ESIResponse): ReifyResult<List<TypeMarketStatistic>>{
        return responseToEntityList(esiResponse)
    }

    fun regionOrdersRaw(regionId: Int, orderType: OrderType = OrderType.All, page: Int = 1, typeId: Int? = null): ESIResponse {
        return with(createRequest("/markets/$regionId/orders")) {
            this.page = page
            addQueryParam("order_type", orderType.toString().toLowerCase())
            typeId?.let { addQueryParam("type_id", it.toString()) }
            execute()
        }
    }

    fun regionOrders(regionId: Int, orderType: OrderType = OrderType.All, page: Int = 1, typeId: Int? = null): ReifyResult<List<MarketOrder>> {
        return regionOrders(regionOrdersRaw(regionId, orderType, page, typeId))
    }

    fun regionOrders(esiResponse: ESIResponse): ReifyResult<List<MarketOrder>> {
        return responseToEntityList(esiResponse)
    }

    fun marketRegionTypesRaw(regionId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/markets/$regionId/types")) {
            this.page = page
            execute()
        }
    }

    fun marketRegionTypes(regionId: Int, page: Int = 1): ReifyResult<List<Int>> {
        return marketRegionTypes(marketRegionTypesRaw(regionId, page))
    }

    fun marketRegionTypes(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun marketGroupsRaw(): ESIResponse {
        return callExecute("/markets/groups")
    }

    fun marketGroups(): ReifyResult<List<Int>> {
        return marketGroups(marketGroupsRaw())
    }

    fun marketGroups(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun marketGroupRaw(marketGroupId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/markets/groups/$marketGroupId")){
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun marketGroup(marketGroupId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<MarketGroup> {
        return marketGroup(marketGroupRaw(marketGroupId, acceptLanguages))
    }

    fun marketGroup(esiResponse: ESIResponse): ReifyResult<MarketGroup> {
        return responseToEntity(esiResponse)
    }

    fun marketPricesRaw(): ESIResponse {
        return callExecute("/markets/prices")
    }

    fun marketPrices(): ReifyResult<List<MarketPrice>> {
        return marketPrices(marketPricesRaw())
    }

    fun marketPrices(esiResponse: ESIResponse): ReifyResult<List<MarketPrice>> {
        return responseToEntityList(esiResponse)
    }

    fun marketStructureOrdersRaw(structureId: Long, page: Int = 1): ESIResponse {
        return with(createRequest("/markets/structures/$structureId", authorization = true)) {
            this.page = page
            execute()
        }
    }

    fun marketStructureOrders(structureId: Long, page: Int = 1): ReifyResult<List<StructureMarketOrder>> {
        return marketStructureOrders(marketStructureOrdersRaw(structureId, page))
    }

    fun marketStructureOrders(esiResponse: ESIResponse): ReifyResult<List<StructureMarketOrder>> {
        return responseToEntityList(esiResponse)
    }
}