package com.eve_engine.esi4k.resource

import com.eve_engine.esi4k.*
import com.eve_engine.esi4k.model.Asset
import com.eve_engine.esi4k.model.AssetLocation
import com.eve_engine.esi4k.model.AssetName

class AssetResources(client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterAssetsRaw(characterId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/characters/$characterId/assets", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun characterAssets(characterId: Int, page: Int = 1): ReifyResult<List<Asset>> {
        return characterAssets(characterAssetsRaw(characterId, page))
    }

    fun characterAssets(esiResponse: ESIResponse): ReifyResult<List<Asset>> {
        return responseToEntityList(esiResponse)
    }

    fun characterAssetsLocationsRaw(characterId: Int, itemIds: List<Long>): ESIResponse {
        return callExecute("/characters/$characterId/assets/locations", HttpMethod.POST, true, mapper.writeValueAsString(itemIds))
    }

    fun characterAssetsLocations(characterId: Int, itemIds: List<Long>): ReifyResult<List<AssetLocation>> {
        return characterAssetsLocations(characterAssetsLocationsRaw(characterId, itemIds))
    }

    fun characterAssetsLocations(esiResponse: ESIResponse): ReifyResult<List<AssetLocation>> {
        return responseToEntityList(esiResponse)
    }

    fun characterAssetsNamesRaw(characterId: Int, itemIds: List<Int>): ESIResponse {
        return callExecute("/characters/$characterId/assets/names", HttpMethod.POST, true, mapper.writeValueAsString(itemIds))
    }

    fun characterAssetsNames(characterId: Int, itemIds: List<Int>): ReifyResult<List<AssetName>> {
        return characterAssetsNames(characterAssetsNamesRaw(characterId, itemIds))
    }

    fun characterAssetsNames(esiResponse: ESIResponse): ReifyResult<List<AssetName>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationAssetsRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/assets", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationAssets(corporationId: Int, page: Int = 1): ReifyResult<List<Asset>> {
        return corporationAssets(corporationAssetsRaw(corporationId, page))
    }

    fun corporationAssets(esiResponse: ESIResponse): ReifyResult<List<Asset>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationsAssetsLocationsRaw(corporationsId: Int, itemIds: List<Int>): ESIResponse {
        return callExecute("/corporationss/$corporationsId/assets/locations", HttpMethod.POST, true, mapper.writeValueAsString(itemIds))
    }

    fun corporationsAssetsLocations(corporationsId: Int, itemIds: List<Int>): ReifyResult<List<AssetLocation>> {
        return corporationsAssetsLocations(corporationsAssetsLocationsRaw(corporationsId, itemIds))
    }

    fun corporationsAssetsLocations(esiResponse: ESIResponse): ReifyResult<List<AssetLocation>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationsAssetsNamesRaw(corporationsId: Int, itemIds: List<Int>): ESIResponse {
        return callExecute("/corporationss/$corporationsId/assets/names", HttpMethod.POST, true, mapper.writeValueAsString(itemIds))
    }

    fun corporationsAssetsNames(corporationsId: Int, itemIds: List<Int>): ReifyResult<List<AssetName>> {
        return corporationsAssetsNames(corporationsAssetsNamesRaw(corporationsId, itemIds))
    }

    fun corporationsAssetsNames(esiResponse: ESIResponse): ReifyResult<List<AssetName>> {
        return responseToEntityList(esiResponse)
    }

}