package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterSkills (
        @JsonProperty("skills") val skills: List<CharacterSkill>,
        @JsonProperty("total_sp") val totalSp: Long,
        @JsonProperty("unallocated_sp") val unallocatedSp: Int? = null
)

data class CharacterSkill (
        @JsonProperty("active_skill_level") val activeSkillLevel: Int,
        @JsonProperty("skill_id") val skillId: Int,
        @JsonProperty("skillpoints_in_skill") val skillpointsInSkill: Long,
        @JsonProperty("trained_skill_level") val trainedSkillLevel: Int
)