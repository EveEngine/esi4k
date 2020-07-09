package com.eve.engine.esi4k.model.internal

import com.fasterxml.jackson.annotation.JsonProperty

data class NewFleetSettings (
        @JsonProperty("is_free_move") val isFreeMove: Boolean? = null,
        @JsonProperty("motd") val motd: String? = null
)