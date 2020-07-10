package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class MailHeader (
        @JsonProperty("from") val from: Int? = null,
        @JsonProperty("is_read") val isRead: Boolean? = null,
        @JsonProperty("labels") val labels: List<Int>? = null,
        @JsonProperty("mail_id") val mailId: Int,
        @JsonProperty("recipients") val recipients: List<Recipient>? = null,
        @JsonProperty("subject") val subject: String? = null,
        @JsonProperty("timestamp") val timestamp: String? = null
)