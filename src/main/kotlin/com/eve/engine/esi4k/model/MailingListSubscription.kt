package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MailingListSubscription (
        @JsonProperty("mailing_list_id") val mailingListId: Int,
        @JsonProperty("name") val name: String
)