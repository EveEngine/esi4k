package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class IdToNameResult(
        @JsonProperty("name") val name: String,
        @JsonProperty("id") val id: Int,
        @JsonProperty("category") val category: String
)
