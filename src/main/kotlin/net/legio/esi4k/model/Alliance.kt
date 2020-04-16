package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Alliance(
    @JsonProperty("creator_corporation_id") val creatorCorporationId: Int,
    @JsonProperty("creator_id") val creatorId: Int,
    @JsonProperty("date_founded") val dateFounded: String,
    @JsonProperty("executor_corporation_id") val executorCorporationId: Int?,
    @JsonProperty("faction_id") val factionId: Int?,
    @JsonProperty("name") val name: String,
    @JsonProperty("ticker") val ticker: String
)