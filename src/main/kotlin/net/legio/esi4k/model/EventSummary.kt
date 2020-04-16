package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class EventSummary(
    @JsonProperty("event_response") val eventResponse: EventResponse? = null,
    @JsonProperty("event_id") val eventId: Int? = null,
    @JsonProperty("importance") val importance: Int? = null,
    @JsonProperty("event_date") val eventDate: String? = null,
    @JsonProperty("title") val title: String? = null
)

enum class EventResponse {
    Declined, NotResponded, Accepted, Tentative
}