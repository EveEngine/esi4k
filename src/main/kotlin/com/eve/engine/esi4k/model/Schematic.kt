package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Schematic (
        @JsonProperty("cycle_time") val cycleTime: Int,
        @JsonProperty("schematic_name") val schematicName: String
)