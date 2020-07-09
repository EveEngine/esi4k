package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ContractItem (
    @JsonProperty("is_included") val isIncluded: Boolean,
    @JsonProperty("is_singleton") val isSingleton: Boolean,
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("raw_quantity") val rawQuantity: Int? = null,
    @JsonProperty("record_id") val recordId: Long,
    @JsonProperty("type_id") val typeId: Int
)