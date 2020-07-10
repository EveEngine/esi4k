package com.eve.engine.esi4k.model.internal

import com.fasterxml.jackson.annotation.JsonProperty

open class FleetMovement (
        @JsonProperty("role") val role: String,
        @JsonProperty("squad_id") val squadId: Long? = null,
        @JsonProperty("wing_id") val wingId: Long? = null
)