package com.eve.engine.esi4k.model


import com.fasterxml.jackson.annotation.JsonProperty

open class FleetWing(
        @JsonProperty("squads") val squads: List<Squad>,
        @JsonProperty("name") val name: String,
        @JsonProperty("id") val id: Long
)


open class Squad(
        @JsonProperty("name") val name: String,
        @JsonProperty("id") val id: Long
)


