package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MailMetadata (
        @JsonProperty("labels") val labels: List<Int>? = null,
        @JsonProperty("read") val read: Boolean? = null
)