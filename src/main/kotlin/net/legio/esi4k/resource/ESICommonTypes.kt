package net.legio.esi4k.resource

import com.fasterxml.jackson.annotation.JsonProperty

data class Position (
    @JsonProperty("x") var x: Double,
    @JsonProperty("y") val y: Double,
    @JsonProperty("z") val z: Double
)