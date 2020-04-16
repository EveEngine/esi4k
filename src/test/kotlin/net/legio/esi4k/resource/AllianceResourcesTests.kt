package net.legio.esi4k.resource

import net.legio.esi4k.ESIClient
import org.junit.jupiter.api.*
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import org.junit.jupiter.params.ParameterizedTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("alliance resources tests")
class AllianceResourcesTests {

    private val esiClient = ESIClient()
    private val allianceResources = AllianceResources(esiClient)
    private val allianceTestId = 99000006

    @Test
    fun `should get alliance ids raw`(){
        val response = allianceResources.alliancesIdsRaw()
        assert(response.code == 200)
    }

    @Test
    fun `should get alliance ids typed`(){
        val reifyResult = allianceResources.alliancesIds()
        assert(reifyResult is GoodReify)
        val data = (reifyResult as GoodReify).data
        assert(!data.isNullOrEmpty())
    }

    @Test
    fun `should get alliance raw`(){
        val alliance = allianceResources.allianceRaw(allianceTestId)
        assert(alliance.code == 200)
    }

    @Test
    fun `should get alliance typed`(){
        val alliance = allianceResources.alliance(allianceTestId)
        assert(alliance is GoodReify)
        assert((alliance as GoodReify).data != null)
    }

    @Test
    fun `should get alliance corporations ids raw`() {
        val corporations = allianceResources.allianceCorporationIdsRaw(allianceTestId)
        assert(corporations.code == 200)
    }

    @Test
    fun `should get alliance corporations ids typed`(){
        val corporations = allianceResources.allianceCorporationIds(allianceTestId)
        assert(corporations is GoodReify)
        val data = (corporations as GoodReify).data
        assert(data != null)
        assert(data!!.isNotEmpty())
    }

    @Test
    fun `should get alliance icons raw`(){
        val icons = allianceResources.allianceIconsRaw(allianceTestId)
        assert(icons.code == 200)
    }

    @Test
    fun `should get alliance icons typed`() {
        val icons = allianceResources.allianceIcons(allianceTestId)
        assert(icons is GoodReify)
        val data = (icons as GoodReify).data
        assert(data != null)
    }

}