package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Faction (
        @JsonProperty("corporation_id") val corporationId: Int? = null,
        @JsonProperty("description") val description: String,
        @JsonProperty("faction_id") val factionId: Int,
        @JsonProperty("is_unique") val isUnique: Boolean? = null,
        @JsonProperty("militia_corporation_id") val militiaCorporationId: Int? = null,
        @JsonProperty("name") val name: String,
        @JsonProperty("size_factor") val sizeFactor: Float,
        @JsonProperty("solar_system_id") val solarSystemId: Int? = null,
        @JsonProperty("station_count") val stationCount: Int,
        @JsonProperty("station_system_count") val stationSystemCount: Int
)