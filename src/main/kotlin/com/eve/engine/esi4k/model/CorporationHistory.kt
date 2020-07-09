package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CorporationHistory(
    @JsonProperty("corporation_id") val corporationId: Int,
    @JsonProperty("is_deleted") val isDeleted: Boolean? = null,
    @JsonProperty("record_id") val recordId: Int,
    @JsonProperty("start_date") val startDate: String
)