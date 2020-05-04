package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class WingCreated (
        @JsonProperty("wing_id") val wingId: Long
)