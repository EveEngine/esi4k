package net.legio.esi4k.resource.auth

import net.legio.esi4k.AuthRequiredResources
import net.legio.esi4k.resource.AssetResources
import net.legio.esi4k.resource.GoodReify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("asset resources tests (auth required)")
class AssetsResourcesTests: AuthRequiredResources() {

    private val assetResources = AssetResources(esiClient)

    @Test
    fun `should get character assets raw`(){
        val assets = assetResources.characterAssetsRaw(authTestProps.characterId)
        assert(assets.code == 200)
    }

    @Test
    fun `should get character assets typed`() {
        val assets = assetResources.characterAssets(authTestProps.characterId)
        assert(assets is GoodReify)
        val data = (assets as GoodReify).data
        assert(!data.isNullOrEmpty())
    }

    @Test
    fun `should get character assets locations raw`(){
        val assets = assetResources.characterAssets(authTestProps.characterId)
        val assetsList = (assets as GoodReify).data
        val itemIds = assetsList?.map { asset -> asset.itemId }
        val response = assetResources.characterAssetsLocationsRaw(authTestProps.characterId, itemIds!!)
        assert(response.code == 200)
    }

    @Test
    fun `should get character assets locations typed`(){
        val assets = assetResources.characterAssets(authTestProps.characterId)
        val assetsList = (assets as GoodReify).data
        val itemIds = assetsList?.asSequence()?.map { asset -> asset.itemId }?.toList()
        val locations = assetResources.characterAssetsLocations(authTestProps.characterId, itemIds!!)
        assert(locations is GoodReify)
        val data = (locations as GoodReify).data
        assert(!data.isNullOrEmpty())
    }

}