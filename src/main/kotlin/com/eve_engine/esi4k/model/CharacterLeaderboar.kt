package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterLeaderboard (
    @JsonProperty("kills") val kills: CharacterLeaderboardKills,
    @JsonProperty("victory_points")  val victoryPoints: CharacterLeaderboardVictoryPoints
)

data class CharacterLeaderboardKills (
    @JsonProperty("active_total") val activeTotal: List<CharacterKills>,
    @JsonProperty("last_week") val lastWeek: List<CharacterKills>,
    @JsonProperty("yesterday") val yesterday: List<CharacterKills>
)

data class CharacterKills (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("character_id") val characterId: Int? = null
)

data class CharacterLeaderboardVictoryPoints (
    @JsonProperty("active_total") val activeTotal: List<CharacterVictoryPoints>,
    @JsonProperty("last_week") val lastWeek: List<CharacterVictoryPoints>,
    @JsonProperty("yesterday") val yesterday: List<CharacterVictoryPoints>
)

data class CharacterVictoryPoints (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("character_id") val characterId: Int? = null
)