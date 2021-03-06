package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class SystemKills(
        @JsonProperty("npc_kills") val npcKills: Int,
        @JsonProperty("ship_kills") val shipKills: Int,
        @JsonProperty("system_id") val systemId: Int,
        @JsonProperty("pod_kills") val podKills: Int
)