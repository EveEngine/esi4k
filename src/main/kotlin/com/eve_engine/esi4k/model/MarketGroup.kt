package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MarketGroup (
        @JsonProperty("description") val description: String,
        @JsonProperty("market_group_id") val marketGroupId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("parent_group_id") val parentGroupId: Int? = null,
        @JsonProperty("types") val types: List<Int>
)