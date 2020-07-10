package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class ContactLabel (
    @JsonProperty("label_id") val lableId: Long,
    @JsonProperty("label_name") val labelName: String
)