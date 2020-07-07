package com.eve_engine.esi4k.model.internal

import com.fasterxml.jackson.annotation.JsonProperty

data class FleetInvitation (
        @JsonProperty("character_id") val characterId: Int,
        @JsonProperty("role") val role: String,
        @JsonProperty("squad_id") val squadId: Long? = null,
        @JsonProperty("wind_id") val windId: Long? = null
)