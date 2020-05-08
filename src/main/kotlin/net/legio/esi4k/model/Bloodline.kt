package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Bloodline (
        @JsonProperty("bloodline_id") val bloodlineId: Int,
        @JsonProperty("charisma") val charisma: Int,
        @JsonProperty("corporation_id") val corporationId: Int,
        @JsonProperty("description") val description: String,
        @JsonProperty("intelligence") val intelligence: Int,
        @JsonProperty("memory") val memory: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("perception") val perception: Int,
        @JsonProperty("race_id") val raceId: Int,
        @JsonProperty("ship_type_id") val shipTypeId: Int,
        @JsonProperty("willpower") val willpower: Int
)