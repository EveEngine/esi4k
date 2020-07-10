package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class SystemJumps (
        @JsonProperty("ship_jumps") val shipJumps: Int,
        @JsonProperty("system_id") val systemId: Int
)