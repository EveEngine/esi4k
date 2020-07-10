package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class InsurancePrice (
        @JsonProperty("levels") val levels: List<InsuranceLevel>,
        @JsonProperty("type_id") val typeId: Int
)

open class InsuranceLevel (
        @JsonProperty("cost") val cost: Float,
        @JsonProperty("name") val name: String,
        @JsonProperty("payout") val payout: Float
)