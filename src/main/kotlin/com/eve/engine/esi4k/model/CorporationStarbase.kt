package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CorporationStarbase (
    @JsonProperty("moon_id") val moonId: Int? = null,
    @JsonProperty("onlined_since") val onlinedSince: String? = null,
    @JsonProperty("reinforced_until") val reinforcedUntil: String? = null,
    @JsonProperty("starbase_id") val starbaseId: Long,
    @JsonProperty("state") val state: StarbaseState? = null,
    @JsonProperty("system_id") val systemId: Int,
    @JsonProperty("type_id") val typeId: Int,
    @JsonProperty("unanchor_at") val unanchorAt: String? = null
)

enum class StarbaseState {
    Offline, Online, Onlining, Reinforced, Unanchoring
}