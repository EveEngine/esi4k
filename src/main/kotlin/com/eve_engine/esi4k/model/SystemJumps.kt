package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SystemJumps (
        @JsonProperty("ship_jumps") val shipJumps: Int,
        @JsonProperty("system_id") val systemId: Int
)