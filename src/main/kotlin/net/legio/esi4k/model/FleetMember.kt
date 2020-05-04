package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class FleetMember(
        @JsonProperty("role_name") val roleName: String,
        @JsonProperty("ship_type_id") val shipTypeId: Int,
        @JsonProperty("takes_fleet_warp") val takesFleetWarp: Boolean,
        @JsonProperty("role") val role: FleetRole,
        @JsonProperty("squad_id") val squadId: Long,
        @JsonProperty("station_id") val stationId: Int? = null,
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("character_id") val characterId: Int,
        @JsonProperty("join_time") val joinTime: String,
        @JsonProperty("wing_id") val wingId: Long
)