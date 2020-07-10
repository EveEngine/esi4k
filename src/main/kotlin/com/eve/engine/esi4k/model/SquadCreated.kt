package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class SquadCreated (
        @JsonProperty("squad_id") val squadId: Long
)