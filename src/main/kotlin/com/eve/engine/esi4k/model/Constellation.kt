package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Constellation (
        @JsonProperty("constellation_id") val constellationId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("position") val position: Position,
        @JsonProperty("region_id") val regionId: Int,
        @JsonProperty("systems") val systems: List<Int>
)