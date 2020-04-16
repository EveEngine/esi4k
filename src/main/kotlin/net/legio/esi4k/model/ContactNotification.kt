package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ContactNotification(
    @JsonProperty("send_date") val sendDate: String,
    @JsonProperty("sender_character_id") val senderCharacterId: Int,
    @JsonProperty("standing_level") val standingLevel: Double,
    @JsonProperty("notification_id") val notificationId: Int,
    @JsonProperty("message") val message: String
) {
    fun standingLevelAsString(): String {
        return when(standingLevel){
            -10.0 -> "Terrible"
            in -9.99..-5.00 -> "Bad"
            in -4.99..4.99 -> "Neutral"
            in 5.0..9.99 -> "Good"
            10.0 -> "Excellent"
            else -> "[-Error-]"
        }
    }
}