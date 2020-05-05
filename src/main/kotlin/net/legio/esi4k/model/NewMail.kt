package net.legio.esi4k.model

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

enum class RecipientClass(val value: String) {
    Alliance("alliance"),
    Character("character"),
    Corporation("corporation"),
    MailingList("mailing_list");
}