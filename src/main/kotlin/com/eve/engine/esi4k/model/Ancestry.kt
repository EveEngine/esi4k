package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Ancestry (
        @JsonProperty("bloodline_id") val bloodlineId: Int,
        @JsonProperty("description") val description: String,
        @JsonProperty("icon_id") val iconId: Int? = null,
        @JsonProperty("id") val ancestryId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("short_description") val shortDescription: String? = null
)