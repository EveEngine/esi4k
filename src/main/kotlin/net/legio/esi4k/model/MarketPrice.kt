package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MarketPrice (
        @JsonProperty("adjusted_price") val adjustedPrice: Double? = null,
        @JsonProperty("average_price") val averagePrice: Double? = null,
        @JsonProperty("type_id") val typeId: Int
)