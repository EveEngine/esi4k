package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Planet(
        @JsonProperty("planet_id") val planetId: Int,
        @JsonProperty("system_id") val systemId: Int,
        @JsonProperty("type_id") val typeId: Int,
        @JsonProperty("name") val name: String = "",
        @JsonProperty("position") val position: Position
)