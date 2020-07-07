package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class FactionWarfareSystem (
    @JsonProperty("contested") val contested: Contested,
    @JsonProperty("occupier_faction_id") val occupierFactionId: Int,
    @JsonProperty("owner_faction_id") val ownerFactionId: Int,
    @JsonProperty("solar_system_id") val solarSystemId: Int,
    @JsonProperty("victory_points") val victoryPoints: Int,
    @JsonProperty("victory_points_threshold") val victoryPointsThreshold: Int
)

enum class Contested {
    Captured, Contested, Unconstested, Vulnerable
}