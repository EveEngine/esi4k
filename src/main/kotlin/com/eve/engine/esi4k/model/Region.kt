package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Region(
        @JsonProperty("constellations") val constellations: List<Int>?,
        @JsonProperty("name") val name: String,
        @JsonProperty("region_id") val regionId: Int,
        @JsonProperty("description") val description: String? = null
)