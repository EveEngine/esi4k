package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Affiliation(
    @JsonProperty("alliance_id") val allianceId: Int? = null,
    @JsonProperty("character_id") val characterId: Int,
    @JsonProperty("corporation_id") val corporationId: Int,
    @JsonProperty("faction_id") val factionId: Int? = null
)