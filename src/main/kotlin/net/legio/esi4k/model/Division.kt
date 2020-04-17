package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Division (
    @JsonProperty("hangar") val hangar: List<Hangar>? = null,
    @JsonProperty("wallet") val wallet: List<Wallet>? = null
)

data class Hangar (
    @JsonProperty("division") val division: Int? = null,
    @JsonProperty("name") val name: String? = null
)

data class Wallet (
    @JsonProperty("division") val division: Int? = null,
    @JsonProperty("name") val name: String? = null
)
