package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class AsteroidBelt (
        @JsonProperty("name") val name: String,
        @JsonProperty("position") val position: Position,
        @JsonProperty("system_id") val systemId: Int
)