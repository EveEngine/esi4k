package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SquadCreated (
        @JsonProperty("squad_id") val squadId: Long
)