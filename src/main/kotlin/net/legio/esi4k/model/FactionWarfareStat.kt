package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class FactionWarfareStat (
    @JsonProperty("faction_id") val factionId: Int,
    @JsonProperty("kills") val kills: Kills,
    @JsonProperty("pilots") val pilots: Int,
    @JsonProperty("systems_controlled") val systemsControlled: Int,
    @JsonProperty("victory_points") val victoryPoints: VictoryPoints
)