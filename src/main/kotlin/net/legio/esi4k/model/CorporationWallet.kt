package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CorporationWallet (
        @JsonProperty("balance") val balance: Double,
        @JsonProperty("division") val division: Int
)