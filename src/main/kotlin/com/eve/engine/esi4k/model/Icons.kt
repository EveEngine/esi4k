package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Icons (
    @JsonProperty("px128x128") val px128x128: String,
    @JsonProperty("px64x64") val px64x64: String
)