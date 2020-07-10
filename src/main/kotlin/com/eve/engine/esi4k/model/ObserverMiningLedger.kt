package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class ObserverMiningLedger (
        @JsonProperty("character_id") val characterId: Int,
        @JsonProperty("last_updated") val lastUpdated: String,
        @JsonProperty("quantity") val quantity: Long,
        @JsonProperty("recorded_corporation_id") val recordedCorporationId: Int,
        @JsonProperty("type_id") val typeId: Int
)