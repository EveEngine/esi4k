package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Attendee(
    @JsonProperty("character_id") val characterId: Int,
    @JsonProperty("event_response") val eventResponse: EventResponse
)