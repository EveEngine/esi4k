package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SquadCreated (
        @JsonProperty("squad_id") val squadId: Long
)