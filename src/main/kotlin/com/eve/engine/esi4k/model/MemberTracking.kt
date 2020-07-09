package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MemberTracking (
    @JsonProperty("base_id") val baseId: Int? = null,
    @JsonProperty("character_id") val characterId: Int,
    @JsonProperty("location_id") val locationId: Long? = null,
    @JsonProperty("logoff_date") val logoffDate: String? = null,
    @JsonProperty("logon_date") val logonDate: String? = null,
    @JsonProperty("ship_type_id") val shipTypeId: String? = null,
    @JsonProperty("start_date") val startDate: String? = null
)