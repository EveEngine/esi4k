package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class NameToIdResult (
        @JsonProperty("agent") val agent: List<NameToId>? = null,
        @JsonProperty("alliance") val alliance: List<NameToId>? = null,
        @JsonProperty("character") val character: List<NameToId>? = null,
        @JsonProperty("constellation") val constellation: List<NameToId>? = null,
        @JsonProperty("corporation") val corporation: List<NameToId>? = null,
        @JsonProperty("faction") val faction: List<NameToId>? = null,
        @JsonProperty("inventory_type") val inventoryType: List<NameToId>? = null,
        @JsonProperty("region") val region: List<NameToId>? = null,
        @JsonProperty("solar_system") val solarSystem: List<NameToId>? = null,
        @JsonProperty("station") val station: List<NameToId>? = null,
        @JsonProperty("structure") val structure: List<Long>? = null
)

data class NameToId (
        @JsonProperty("id") val id: Int,
        @JsonProperty("name") val name: String
)