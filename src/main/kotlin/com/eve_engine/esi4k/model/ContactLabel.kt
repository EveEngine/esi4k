package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ContactLabel (
    @JsonProperty("label_id") val lableId: Long,
    @JsonProperty("label_name") val labelName: String
)