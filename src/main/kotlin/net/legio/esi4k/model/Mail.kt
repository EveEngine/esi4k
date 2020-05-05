package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Mail (
        @JsonProperty("body") val body: String? = null,
        @JsonProperty("from") val from: Int? = null,
        @JsonProperty("labels") val labels: List<Int>? = null,
        @JsonProperty("read") val read: Boolean? = null,
        @JsonProperty("recipients") val recipients: List<Recipient>? = null,
        @JsonProperty("subject") val subject: String? = null,
        @JsonProperty("timestamp") val timestamp: String? = null
)