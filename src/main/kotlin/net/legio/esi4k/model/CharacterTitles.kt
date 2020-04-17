package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterTitles (
    @JsonProperty("character_id") val characterId: Int,
    @JsonProperty("titles") val titles: List<Int>
)