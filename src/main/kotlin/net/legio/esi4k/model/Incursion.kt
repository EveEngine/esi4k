package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Incursion (
    @JsonProperty("constellation_id") val constellationId: Int,
    @JsonProperty("faction_id") val factionId: Int,
    @JsonProperty("has_boss") val hasBoss: Boolean,
    @JsonProperty("infested_solar_systems") val infestedSolarSystems: List<Int>,
    @JsonProperty("influence") val influence: Float,
    @JsonProperty("staging_solar_system") val stagingSolarSystem: Int,
    @JsonProperty("state") val state: IncursionState,
    @JsonProperty("type") val type: String
)

enum class IncursionState {
    Withdrawing, Mobilizing, Established
}