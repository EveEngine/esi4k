package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CharacterLeaderboard (
    @JsonProperty("kills") val kills: CharacterLeaderboardKills,
    @JsonProperty("victory_points")  val victoryPoints: CharacterLeaderboardVictoryPoints
)

open class CharacterLeaderboardKills (
    @JsonProperty("active_total") val activeTotal: List<CharacterKills>,
    @JsonProperty("last_week") val lastWeek: List<CharacterKills>,
    @JsonProperty("yesterday") val yesterday: List<CharacterKills>
)

open class CharacterKills (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("character_id") val characterId: Int? = null
)

open class CharacterLeaderboardVictoryPoints (
    @JsonProperty("active_total") val activeTotal: List<CharacterVictoryPoints>,
    @JsonProperty("last_week") val lastWeek: List<CharacterVictoryPoints>,
    @JsonProperty("yesterday") val yesterday: List<CharacterVictoryPoints>
)

open class CharacterVictoryPoints (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("character_id") val characterId: Int? = null
)