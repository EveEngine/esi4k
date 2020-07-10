package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Corporation (
    @JsonProperty("alliance_id") val allianceId: Int? = null,
    @JsonProperty("ceo_id") val ceoId: Int,
    @JsonProperty("creator_id") val creatorId: Int,
    @JsonProperty("date_founded") val dateFounded: String? = null,
    @JsonProperty("description") val description: String? = null,
    @JsonProperty("faction_id") val factionId: String? = null,
    @JsonProperty("home_station_id") val homeStationId: Int? = null,
    @JsonProperty("member_count") val memberCount: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("shares") val shares: Long? = null,
    @JsonProperty("tax_rates") val taxRates: Float,
    @JsonProperty("ticker") val ticker: String,
    @JsonProperty("url") val url: String? = null,
    @JsonProperty("war_eligible") val warEligible: Boolean? = null
)