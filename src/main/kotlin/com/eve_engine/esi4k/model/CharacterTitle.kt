package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterTitle(
    @JsonProperty("name") val name: String? = null,
    @JsonProperty("title_id") val titleId: Int? = null
)