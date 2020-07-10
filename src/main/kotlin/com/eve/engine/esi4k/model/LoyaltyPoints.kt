package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class LoyaltyPoints (
        @JsonProperty("corporation_id") val corporationId: Int,
        @JsonProperty("loyalty_points") val loyaltyPoints: Int
)