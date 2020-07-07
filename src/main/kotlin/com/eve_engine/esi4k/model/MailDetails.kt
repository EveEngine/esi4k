package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MailDetails (
        @JsonProperty("body") val body: String,
        @JsonProperty("recipients") val recipients: List<Int>,
        @JsonProperty("subject") val subject: String,
        @JsonProperty("to_corp_or_alliance_id") val toCorpOrAllianceId: Int? = null,
        @JsonProperty("to_mailing_list_id") val toMailingListId: Int? = null
)