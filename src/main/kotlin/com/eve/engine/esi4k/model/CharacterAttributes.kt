package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterAttributes (
        @JsonProperty("accrued_remap_cooldown_date") val accruedRemapCooldownDate: String? = null,
        @JsonProperty("bonus_remaps") val bonusRemaps: Int? = null,
        @JsonProperty("charisma") val charisma: Int,
        @JsonProperty("intelligence") val intelligence: Int,
        @JsonProperty("last_remap_date") val lastRemapDate: String? = null,
        @JsonProperty("memory") val memory: Int,
        @JsonProperty("perception") val perception: Int,
        @JsonProperty("willpower") val willpower: Int
)