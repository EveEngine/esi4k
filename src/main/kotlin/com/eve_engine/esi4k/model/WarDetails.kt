package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class WarDetails (
        @JsonProperty("aggressor") val aggressor: WarParticipant,
        @JsonProperty("allies") val allies: List<Ally>? = null,
        @JsonProperty("declared") val declared: String,
        @JsonProperty("defender") val defender: WarParticipant,
        @JsonProperty("finished") val finished: String? = null,
        @JsonProperty("id") val warId: Int,
        @JsonProperty("mutual") val mutual: Boolean,
        @JsonProperty("open_for_allies") val openForAllies: Boolean,
        @JsonProperty("retracted") val retracted: String? = null,
        @JsonProperty("started") val started: String? = null
)

data class WarParticipant (
        @JsonProperty("alliance_id") val allianceId: Int? = null,
        @JsonProperty("corporation_id") val corporationId: Int? = null,
        @JsonProperty("isk_destroyed") val iskDestroyed: Float,
        @JsonProperty("ships_killed") val shipsKilled: Int
)

data class Ally (
        @JsonProperty("alliance_id") val allianceId: Int? = null,
        @JsonProperty("corporation_id") val corporationId: Int? = null
)