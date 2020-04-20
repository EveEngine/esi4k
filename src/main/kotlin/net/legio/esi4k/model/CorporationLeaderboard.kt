package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CorporationLeaderboard (
    @JsonProperty("kills") val kills: CorporationLeaderboardKills,
    @JsonProperty("victory_points")  val victoryPoints: CorporationLeaderboardVictoryPoints
)

data class CorporationLeaderboardKills (
    @JsonProperty("active_total") val activeTotal: List<CorporationKills>,
    @JsonProperty("last_week") val lastWeek: List<CorporationKills>,
    @JsonProperty("yesterday") val yesterday: List<CorporationKills>
)

data class CorporationKills (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("corporation_id") val corporationId: Int? = null
)

data class CorporationLeaderboardVictoryPoints (
    @JsonProperty("active_total") val activeTotal: List<CorporationVictoryPoints>,
    @JsonProperty("last_week") val lastWeek: List<CorporationVictoryPoints>,
    @JsonProperty("yesterday") val yesterday: List<CorporationVictoryPoints>
)

data class CorporationVictoryPoints (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("corporation_id") val corporationId: Int? = null
)