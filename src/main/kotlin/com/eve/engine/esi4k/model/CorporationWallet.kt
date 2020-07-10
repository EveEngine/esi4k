package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CorporationWallet (
        @JsonProperty("balance") val balance: Double,
        @JsonProperty("division") val division: Int
)