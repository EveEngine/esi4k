package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Facility (
    @JsonProperty("facility_id") val facilityId: Long,
    @JsonProperty("system_id") val systemId: Int,
    @JsonProperty("type_id") val typeId: Int
)