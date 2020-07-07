package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class JumpFatigue (
    @JsonProperty("jump_fatigue_expire_data") val jumpFatigueExpireData: String? = null,
    @JsonProperty("last_jump_date") val lastJumpDate: String? = null,
    @JsonProperty("last_update_date") val lastUpdateDate: String? = null
)