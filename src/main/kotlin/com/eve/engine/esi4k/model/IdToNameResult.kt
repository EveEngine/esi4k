package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class IdToNameResult(
        @JsonProperty("name") val name: String,
        @JsonProperty("id") val id: Int,
        @JsonProperty("category") val category: String
)
