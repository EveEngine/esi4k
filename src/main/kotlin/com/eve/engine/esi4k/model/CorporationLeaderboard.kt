package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CorporationLeaderboard (
    @JsonProperty("kills") val kills: CorporationLeaderboardKills,
    @JsonProperty("victory_points")  val victoryPoints: CorporationLeaderboardVictoryPoints
)

open class CorporationLeaderboardKills (
    @JsonProperty("active_total") val activeTotal: List<CorporationKills>,
    @JsonProperty("last_week") val lastWeek: List<CorporationKills>,
    @JsonProperty("yesterday") val yesterday: List<CorporationKills>
)

open class CorporationKills (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("corporation_id") val corporationId: Int? = null
)

open class CorporationLeaderboardVictoryPoints (
    @JsonProperty("active_total") val activeTotal: List<CorporationVictoryPoints>,
    @JsonProperty("last_week") val lastWeek: List<CorporationVictoryPoints>,
    @JsonProperty("yesterday") val yesterday: List<CorporationVictoryPoints>
)

open class CorporationVictoryPoints (
    @JsonProperty("amount") val amount: Int? = null,
    @JsonProperty("corporation_id") val corporationId: Int? = null
)