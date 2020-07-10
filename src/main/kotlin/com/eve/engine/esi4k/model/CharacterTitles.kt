package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CharacterTitles (
    @JsonProperty("character_id") val characterId: Int,
    @JsonProperty("titles") val titles: List<Int>
)