package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Portraits(
    @JsonProperty("px128x128") val px128x128: String? = null,
    @JsonProperty("px256x256") val px256x256: String? = null,
    @JsonProperty("px512x512") val px512x512: String? = null,
    @JsonProperty("px64x64") val px64x64: String? = null
)