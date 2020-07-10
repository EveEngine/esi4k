package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Structure(
        @JsonProperty("owner_id") val ownerId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("position") val position: Position? = null,
        @JsonProperty("type_id") val typeId: Int? = null
)