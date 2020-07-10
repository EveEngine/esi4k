package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Division (
    @JsonProperty("hangar") val hangar: List<Hangar>? = null,
    @JsonProperty("wallet") val wallet: List<Wallet>? = null
)

open class Hangar (
    @JsonProperty("division") val division: Int? = null,
    @JsonProperty("name") val name: String? = null
)

open class Wallet (
    @JsonProperty("division") val division: Int? = null,
    @JsonProperty("name") val name: String? = null
)
