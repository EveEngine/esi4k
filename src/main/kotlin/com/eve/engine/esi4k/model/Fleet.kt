package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Fleet(
        @JsonProperty("motd") val motd: String,
        @JsonProperty("is_registered") val isRegistered: Boolean,
        @JsonProperty("is_free_move") val isFreeMove: Boolean,
        @JsonProperty("is_voice_enabled") val isVoiceEnabled: Boolean
)