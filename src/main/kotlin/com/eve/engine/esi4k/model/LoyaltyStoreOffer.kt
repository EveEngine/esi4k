package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class LoyaltyStoreOffer (
        @JsonProperty("ak_cost") val akCost: Int? = null,
        @JsonProperty("isk_cost") val iskCost: Long,
        @JsonProperty("ip_cost") val ipCost: Int,
        @JsonProperty("offer_id") val offerId: Int,
        @JsonProperty("quantity") val quantity: Int,
        @JsonProperty("required_items") val requiredItems: List<RequiredItem>,
        @JsonProperty("type_id") val typeId: Int
)

open class RequiredItem (
        @JsonProperty("type_id") val typeId: Int,
        @JsonProperty("quantity") val quantity: Int
)