package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class InsurancePrice (
        @JsonProperty("levels") val levels: List<InsuranceLevel>,
        @JsonProperty("type_id") val typeId: Int
)

data class InsuranceLevel (
        @JsonProperty("cost") val cost: Float,
        @JsonProperty("name") val name: String,
        @JsonProperty("payout") val payout: Float
)