package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.Datasource
import com.eve.engine.esi4k.ESIClient
import com.eve.engine.esi4k.ESIResponse
import com.eve.engine.esi4k.Version
import com.eve.engine.esi4k.model.CharacterAttributes
import com.eve.engine.esi4k.model.CharacterSkills
import com.eve.engine.esi4k.model.SkillQueue

class SkillsResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterAttributesRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/attributes", authorization = true)
    }

    fun characterAttributes(characterId: Int): ReifyResult<CharacterAttributes> {
        return characterAttributes(characterAttributesRaw(characterId))
    }

    fun characterAttributes(esiResponse: ESIResponse): ReifyResult<CharacterAttributes> {
        return responseToEntity(esiResponse)
    }

    fun characterSkillQueueRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/skillqueue", authorization = true)
    }

    fun characterSkillQueue(characterId: Int): ReifyResult<List<SkillQueue>> {
        return characterSkillQueue(characterSkillQueueRaw(characterId))
    }

    fun characterSkillQueue(esiResponse: ESIResponse): ReifyResult<List<SkillQueue>> {
        return responseToEntityList(esiResponse)
    }

    fun characterSkillsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/skills", authorization = true)
    }

    fun characterSkills(characterId: Int): ReifyResult<CharacterSkills> {
        return characterSkills(characterSkillsRaw(characterId))
    }

    fun characterSkills(esiResponse: ESIResponse): ReifyResult<CharacterSkills> {
        return responseToEntity(esiResponse)
    }

}