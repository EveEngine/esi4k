package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class TypeMarketStatistic (
        @JsonProperty("average") val average: Double,
        @JsonProperty("date") val date: String,
        @JsonProperty("highest") val highest: Double,
        @JsonProperty("lowest") val lowest: Double,
        @JsonProperty("order_count") val orderCount: Long,
        @JsonProperty("volume") val volume: Long
)