package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class KillmailIdHash (
        @JsonProperty("killmail_hash") val killmailHash: String,
        @JsonProperty("killmail_id") val killmailId: Int
)