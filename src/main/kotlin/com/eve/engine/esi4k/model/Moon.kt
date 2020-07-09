package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Moon(
        @JsonProperty("system_id") val systemId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("moon_id") val moonId: Int,
        @JsonProperty("position") val position: Position
)