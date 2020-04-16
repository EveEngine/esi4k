package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Event(
    @JsonProperty("date") val date: String,
    @JsonProperty("duration") val duration: Int,
    @JsonProperty("event_id") val eventId: Int,
    @JsonProperty("owner_name") val ownerName: String,
    @JsonProperty("importance") val importance: Int,
    @JsonProperty("owner_id") val ownerId: Int,
    @JsonProperty("response") val response: String,
    @JsonProperty("text") val text: String,
    @JsonProperty("title") val title: String,
    @JsonProperty("owner_type") val ownerType: OwnerType
)

enum class OwnerType {
    EveServer, Corporation, Faction, Character, Alliance
}