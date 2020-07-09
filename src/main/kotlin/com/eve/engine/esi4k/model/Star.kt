package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Star(
        @JsonProperty("type_id") val typeId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("temperature") val temperature: Int,
        @JsonProperty("luminosity") val luminosity: Double,
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("radius") val radius: Int,
        @JsonProperty("spectral_class") val spectralClass: String,
        @JsonProperty("age") val age: Long
)