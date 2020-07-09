package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Stargate(
        @JsonProperty("system_id") val systemId: Int,
        @JsonProperty("type_id") val typeId: Int,
        @JsonProperty("destination") val destination: Destination,
        @JsonProperty("name") val name: String,
        @JsonProperty("position") val position: Position,
        @JsonProperty("stargate_id") val stargateId: Int
)

data class Destination(
        @JsonProperty("system_id") val systemId: Int,
        @JsonProperty("stargate_id") val stargateId: Int
)