package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class WingCreated (
        @JsonProperty("wing_id") val wingId: Long
)