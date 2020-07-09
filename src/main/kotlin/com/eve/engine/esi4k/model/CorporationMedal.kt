package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CorporationMedal (
    @JsonProperty("created_at") val createdAt: String,
    @JsonProperty("creator_id") val creatorId: Int,
    @JsonProperty("description") val description: String,
    @JsonProperty("medal_id") val medalId: Int,
    @JsonProperty("title") val title: String
)