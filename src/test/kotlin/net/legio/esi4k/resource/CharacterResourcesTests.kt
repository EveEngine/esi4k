package net.legio.esi4k.resource

import net.legio.esi4k.AuthRequiredResources
import net.legio.esi4k.ESIClient
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("character public resources tests")
class CharacterResourcesTests: AuthRequiredResources(){

    private val characterResources = CharacterResources(esiClient)

    @Test
    fun `should get character raw`() {
        val response = characterResources.characterRaw(authTestProps.characterId)
        assert(response.code == 200)
    }

    @Test
    fun `should get character typed`() {
        val reifyResult = characterResources.character(authTestProps.characterId)
        assert(reifyResult is GoodReify)
        val data = (reifyResult as GoodReify).data
        assert(data != null)
    }

    @Test
    fun `should get character corporation history raw`() {
        val response = characterResources.characterCorporationHistoryRaw(authTestProps.characterId)
        assert(response.code == 200)
    }

    @Test
    fun `should get character corporation history typed`() {
        val reifyResult = characterResources.characterCorporationHistory(authTestProps.characterId)
        assert(reifyResult is GoodReify)
        val data = (reifyResult as GoodReify).data
        assert(!data.isNullOrEmpty())
    }

    @Test
    fun `should get character portrait raw`() {
        val response = characterResources.characterPortraitsRaw(authTestProps.characterId)
        assert(response.code == 200)
    }

    @Test
    fun `should get character portrait typed`() {
        val reifyResult = characterResources.characterPortraits(authTestProps.characterId)
        assert(reifyResult is GoodReify)
        val data = (reifyResult as GoodReify).data
        assert(data != null)
    }
}