package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CharacterOnline (
        @JsonProperty("last_login") val lastLogin: String? = null,
        @JsonProperty("last_logout") val lastLogout: String? = null,
        @JsonProperty("logins") val logins: Int? = null,
        @JsonProperty("online") val online: Boolean
)