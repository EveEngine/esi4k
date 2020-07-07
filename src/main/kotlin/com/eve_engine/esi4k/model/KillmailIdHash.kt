package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class KillmailIdHash (
        @JsonProperty("killmail_hash") val killmailHash: String,
        @JsonProperty("killmail_id") val killmailId: Int
)