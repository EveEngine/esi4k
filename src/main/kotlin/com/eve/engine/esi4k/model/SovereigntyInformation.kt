package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SovereigntyInformation (
        @JsonProperty("alliance_id") val allianceId: Int? = null,
        @JsonProperty("corporation_id") val corporationId: Int? = null,
        @JsonProperty("faction_id") val factionId: Int? = null,
        @JsonProperty("system_id") val systemId: Int
)