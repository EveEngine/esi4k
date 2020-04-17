package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ContactLabel (
    @JsonProperty("label_id") val lableId: Long,
    @JsonProperty("label_name") val labelName: String
)