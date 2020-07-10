package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Leaderboard (
    @JsonProperty("kills") val kills: CharacterLeaderboardKills,
    @JsonProperty("victory_points")  val victoryPoints: LeaderboardVictoryPoints
)

open class LeaderboardKills (
    @JsonProperty("active_total") val activeTotal: List<FactionKills>,
    @JsonProperty("last_week") val lastWeek: List<FactionKills>,
    @JsonProperty("yesterday") val yesterday: List<FactionKills>
)

open class FactionKills (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("faction_id") val factionId: Int? = null
)

open class LeaderboardVictoryPoints (
    @JsonProperty("active_total") val activeTotal: List<FactionVictoryPoints>,
    @JsonProperty("last_week") val lastWeek: List<FactionVictoryPoints>,
    @JsonProperty("yesterday") val yesterday: List<FactionVictoryPoints>
)

open class FactionVictoryPoints (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("faction_id") val factionId: Int? = null
)