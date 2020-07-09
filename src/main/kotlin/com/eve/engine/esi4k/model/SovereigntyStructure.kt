package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SovereigntyStructure (
        @JsonProperty("alliance_id") val allianceId: Int,
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("structure_id") val structureId: Long,
        @JsonProperty("structure_type_id") val structureTypeId: Int,
        @JsonProperty("vulnerability_occupancy_level") val vulnerabilityOccupancyLevel: Float? = null,
        @JsonProperty("vulnerability_end_time") val vulnerabilityEndTime: String? = null,
        @JsonProperty("vulnerability_start_time") val vulnerabilityStartTime: String? = null
)