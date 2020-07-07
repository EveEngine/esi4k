package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Leaderboard (
    @JsonProperty("kills") val kills: CharacterLeaderboardKills,
    @JsonProperty("victory_points")  val victoryPoints: LeaderboardVictoryPoints
)

data class LeaderboardKills (
    @JsonProperty("active_total") val activeTotal: List<FactionKills>,
    @JsonProperty("last_week") val lastWeek: List<FactionKills>,
    @JsonProperty("yesterday") val yesterday: List<FactionKills>
)

data class FactionKills (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("faction_id") val factionId: Int? = null
)

data class LeaderboardVictoryPoints (
    @JsonProperty("active_total") val activeTotal: List<FactionVictoryPoints>,
    @JsonProperty("last_week") val lastWeek: List<FactionVictoryPoints>,
    @JsonProperty("yesterday") val yesterday: List<FactionVictoryPoints>
)

data class FactionVictoryPoints (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("faction_id") val factionId: Int? = null
)