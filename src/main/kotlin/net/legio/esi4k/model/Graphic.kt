package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Graphic(
    @JsonProperty("color") val color: Int? = null,
    @JsonProperty("part") val part: Int,
    @JsonProperty("graphic") val graphic: String,
    @JsonProperty("layer") val layer: Int
)