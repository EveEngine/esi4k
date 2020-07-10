package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Character(
    @JsonProperty("alliance_id") val allianceId: Int? = null,
    @JsonProperty("ancestry_id") val ancestryId: Int? = null,
    @JsonProperty("birthday") val birthday:String,
    @JsonProperty("bloodline_id") val bloodlineId: Int,
    @JsonProperty("corporation_id") val corporationId: Int,
    @JsonProperty("description") val description: String? = null,
    @JsonProperty("faction_id") val factionId: Int? = null,
    @JsonProperty("gender") val gender: Gender,
    @JsonProperty("name") val name: String,
    @JsonProperty("race_id") val raceId: Int,
    @JsonProperty("securityStatus") val securityStatus: Float,
    @JsonProperty("title") val title: String? = null
)

enum class Gender {
    Male, Female
}