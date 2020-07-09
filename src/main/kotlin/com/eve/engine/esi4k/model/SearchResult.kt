package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SearchResult (
        @JsonProperty("agent") val agent: List<Int>? = null,
        @JsonProperty("alliance") val alliance: List<Int>? = null,
        @JsonProperty("character") val character: List<Int>? = null,
        @JsonProperty("constellation") val constellation: List<Int>? = null,
        @JsonProperty("corporation") val corporation: List<Int>? = null,
        @JsonProperty("faction") val faction: List<Int>? = null,
        @JsonProperty("inventory_type") val inventoryType: List<Int>? = null,
        @JsonProperty("region") val region: List<Int>? = null,
        @JsonProperty("solar_system") val solarSystem: List<Int>? = null,
        @JsonProperty("station") val station: List<Int>? = null,
        @JsonProperty("structure") val structure: List<Long>? = null
)
