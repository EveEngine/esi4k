package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Standing (
    @JsonProperty("from_id") val fromId: Int,
    @JsonProperty("from_type") val fromType: StandingType,
    @JsonProperty("standing") val standing: Float
){
    companion object {
        @JvmStatic
        fun standingLevelAsString(value: Double): String {
            return when(value){
                -10.0 -> "Terrible"
                in -9.99..-5.00 -> "Bad"
                in -4.99..4.99 -> "Neutral"
                in 5.0..9.99 -> "Good"
                10.0 -> "Excellent"
                else -> "[-Error-]"
            }
        }
    }
}

enum class StandingType {
    Agent, NpcCorp, Faction
}