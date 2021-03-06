package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class ContactNotification(
    @JsonProperty("send_date") val sendDate: String,
    @JsonProperty("sender_character_id") val senderCharacterId: Int,
    @JsonProperty("standing_level") val standingLevel: Double,
    @JsonProperty("notification_id") val notificationId: Int,
    @JsonProperty("message") val message: String
)