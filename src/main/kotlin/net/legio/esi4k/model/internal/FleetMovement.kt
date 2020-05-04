package net.legio.esi4k.model.internal

import com.fasterxml.jackson.annotation.JsonProperty

data class FleetMovement (
        @JsonProperty("role") val role: String,
        @JsonProperty("squad_id") val squadId: Long? = null,
        @JsonProperty("wing_id") val wingId: Long? = null
)