package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class FactionWarfareWar (
    @JsonProperty("against_id") val againstId: Int,
    @JsonProperty("faction_id") val factionId: Int
)