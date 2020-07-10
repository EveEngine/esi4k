package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

open class Location (
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("station_id") val stationId: Int? = null,
        @JsonProperty("structure_id") val structureId: Long? = null
)