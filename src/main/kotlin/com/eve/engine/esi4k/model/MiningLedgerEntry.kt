package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class MiningLedgerEntry (
        @JsonProperty("date") val date: String,
        @JsonProperty("quantity") val quantity: Long,
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("type_id") val  typeId: Int
)