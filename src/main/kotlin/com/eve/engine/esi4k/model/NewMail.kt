package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class NewMail (
        @JsonProperty("approved_cost") val approvedCost: Long? = null,
        @JsonProperty("body") val body: String,
        @JsonProperty("recipients") val recipients: List<Recipient>,
        @JsonProperty("subject") val subject: String
)

data class Recipient(
        @JsonProperty("recipient_id") val recipientId: Int,
        @JsonProperty("recipient_type") val recipientType: String
)

enum class RecipientClass {
    Alliance, Character, Corporation, MailingList;

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}