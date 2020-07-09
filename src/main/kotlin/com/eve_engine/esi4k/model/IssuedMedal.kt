package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class IssuedMedal (
    @JsonProperty("character_id") val characterId: Int,
    @JsonProperty("issued_at") val issuedAt: String,
    @JsonProperty("issuer_id") val issuerId: Int,
     @JsonProperty("medal_id") val medalId: Int,
    @JsonProperty("reason") val reason: String,
    @JsonProperty("status") val status: Status
)