package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MarketOrder (
        @JsonProperty("duration") val duration: Int,
        @JsonProperty("is_buy_order") val isBuyOrder: Boolean,
        @JsonProperty("issued") val issued: String,
        @JsonProperty("location_id") val locationId: Long,
        @JsonProperty("min_volume") val minVolume: Int?,
        @JsonProperty("order_id") val orderId: Long,
        @JsonProperty("price") val price: Double,
        @JsonProperty("range") val range: String,
        @JsonProperty("system_id") val systemId: Int,
        @JsonProperty("type_id") val typeId: Int,
        @JsonProperty("volume_remain") val volumeRemain: Int,
        @JsonProperty("volume_total") val volumeTotal: Int
)

enum class OrderType {
    Buy, Sell, All
}