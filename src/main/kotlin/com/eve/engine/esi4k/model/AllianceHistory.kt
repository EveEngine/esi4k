package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class AllianceHistory (
    @JsonProperty("alliance_id") val allianceId: Int? = null,
    @JsonProperty("id_deleted") val isDeleted: Boolean? = null,
    @JsonProperty("record_id") val recordId: Int,
    @JsonProperty("start_date") val startDate: String
)