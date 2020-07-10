package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CorporationFactionWarfareStats (
    @JsonProperty("enlisted_on") val enlistedOn: String? = null,
    @JsonProperty("faction_id") val factionId: Int? = null,
    @JsonProperty("kills") val kills: List<Kills>,
    @JsonProperty("pilots") val pilots: Int? = null,
    @JsonProperty("victory_points") val victoryPoints: List<VictoryPoints>
)