package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Contact(
    @JsonProperty("contact_id") val contactId: Int,
    @JsonProperty("contact_type") val contactType: ContactType,
    @JsonProperty("label_ids") val labelIds: List<Long>? = null,
    @JsonProperty("standing") val standing: Float
)

enum class ContactType {
    Character, Corporation, Alliance, Faction
}