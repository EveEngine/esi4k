package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class MailMetadata (
        @JsonProperty("labels") val labels: List<Int>? = null,
        @JsonProperty("read") val read: Boolean? = null
)