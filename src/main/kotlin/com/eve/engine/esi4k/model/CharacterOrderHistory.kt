package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CharacterOrderHistory (
        @JsonProperty("duration") val duration: Int,
        @JsonProperty("escrow") val escrow: Double? = null,
        @JsonProperty("is_buy_order") val isBuyOrder: Boolean? = null,
        @JsonProperty("is_corporation") val isCorporation: Boolean,
        @JsonProperty("issued") val issued: String,
        @JsonProperty("location_id") val locationId: Long,
        @JsonProperty("min_volume") val minVolume: Int? = null,
        @JsonProperty("order_id") val orderId: Long,
        @JsonProperty("price") val price: Double,
        @JsonProperty("range") val range: String,
        @JsonProperty("region_id") val regionId: Int,
        @JsonProperty("state") val state: OrderState,
        @JsonProperty("type_id") val typeId: Int,
        @JsonProperty("volume_remain") val volumeRemain: Int,
        @JsonProperty("volume_total") val volumeTotal: Int
)

enum class OrderState {
    Cancelled, Expired
}