package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Medal(
        @JsonProperty("date") val date: String,
        @JsonProperty("medal_id") val medalId: Int,
        @JsonProperty("issuer_id") val issuerId: Int,
        @JsonProperty("reason") val reason: String,
        @JsonProperty("corporation_id") val corporationId: Int,
        @JsonProperty("description") val description: String,
        @JsonProperty("graphics") val graphics: List<MedalGraphic>,
        @JsonProperty("title") val title: String,
        @JsonProperty("status") val status: Status
)

enum class Status {
    Public, Private
}