package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Standing (
    @JsonProperty("from_id") val fromId: Int,
    @JsonProperty("from_type") val fromType: StandingType,
    @JsonProperty("standing") val standing: Float
)

enum class StandingType {
    Agent, NpcCorp, Faction
}