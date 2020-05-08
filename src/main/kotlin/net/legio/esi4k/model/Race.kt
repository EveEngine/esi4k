package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Race(
        @JsonProperty("alliance_id") val allianceId: Int,
        @JsonProperty("race_id") val raceId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("description") val description: String
)