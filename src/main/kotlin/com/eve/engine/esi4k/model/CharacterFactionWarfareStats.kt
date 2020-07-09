package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterFactionWarfareStats (
    @JsonProperty("current_rank") val currentRank: Int? = null,
    @JsonProperty("enlisted_on") val enlistedOn: String? = null,
    @JsonProperty("faction_id") val factionId: Int? = null,
    @JsonProperty("highest_rank") val highestRank: Int? = null,
    @JsonProperty("kills") val kills: List<Kills>,
    @JsonProperty("victory_points") val victoryPoints: List<VictoryPoints>
)

data class Kills (
    @JsonProperty("last_week") val lastWeek: Int? = null,
    @JsonProperty("total") val total: Int? = null,
    @JsonProperty("yesterday") val yesterday: Int? = null
)

data class VictoryPoints (
    @JsonProperty("last_week") val lastWeek: Int? = null,
    @JsonProperty("total") val total: Int? = null,
    @JsonProperty("yesterday") val yesterday: Int? = null
)