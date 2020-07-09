package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterTitles (
    @JsonProperty("character_id") val characterId: Int,
    @JsonProperty("titles") val titles: List<Int>
)