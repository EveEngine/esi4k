package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class IndustryFacilities (
        @JsonProperty("facility_id") val facilityId: Long,
        @JsonProperty("owner_id") val ownerId: Int,
        @JsonProperty("region_id") val regionId: Int,
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("tax") val tax: Float? = null,
        @JsonProperty("type_id") val typeId: Int
)