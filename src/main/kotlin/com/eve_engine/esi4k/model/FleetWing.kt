package com.eve_engine.esi4k.model


import com.fasterxml.jackson.annotation.JsonProperty

data class FleetWing(
        @JsonProperty("squads") val squads: List<Squad>,
        @JsonProperty("name") val name: String,
        @JsonProperty("id") val id: Long
)


data class Squad(
        @JsonProperty("name") val name: String,
        @JsonProperty("id") val id: Long
)


