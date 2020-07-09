package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class EventSummary(
    @JsonProperty("event_response") val eventResponse: EventResponse? = null,
    @JsonProperty("event_id") val eventId: Int? = null,
    @JsonProperty("importance") val importance: Int? = null,
    @JsonProperty("event_date") val eventDate: String? = null,
    @JsonProperty("title") val title: String? = null
)

enum class EventResponse {
    Declined, NotResponded, Accepted, Tentative;

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}