package net.legio.esi4k.resource

import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESISuccessResponse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("universe resources tests")
class UniverseResourcesTests {
    private val esiClient = ESIClient()
    private val universeResources = UniverseResources(esiClient)

    @Test
    fun `should get raw ancestries`() {
        val response = universeResources.ancestriesRaw()
        assert(response is ESISuccessResponse)
        assert(response.code == 200)
    }

    @Test
    fun `should get ancestries typed`() {
        val response = universeResources.ancestries()
        assert(response is GoodReify)
        val data = (response as GoodReify).data
        assert(data != null)
        assert(data!!.isNotEmpty())
        val ancestry = data[0]
    }

    @Test
    fun `should get raw bloodlines`() {
        val response = universeResources.bloodlinesRaw()
        assert(response is ESISuccessResponse)
        assert(response.code == 200)
    }

    @Test
    fun `should get bloodlines typed`() {
        val response = universeResources.bloodlines()
        assert(response is GoodReify)
        val data = (response as GoodReify).data
        assert(data != null)
        assert(data!!.isNotEmpty())
        val bloodline = data[0]
    }


}