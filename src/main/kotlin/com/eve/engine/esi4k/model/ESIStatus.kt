package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter

/**
 *  Status of an Eve ESI route.
 */
open class ESIStatus(
    @JsonProperty("endpoint") val endpoint: String,
    @JsonProperty("method") val method: String,
    @JsonProperty("route") val route: String,
    @JsonProperty("status") val status: RouteStatus,
    @JsonProperty("tags") val tags: List<String>
)

enum class RouteStatus {
    /** Good. */
    Green,
    /** Degraded, meaning slow or potentially dropping requests. */
    Yellow,
    /** Most requests are not succeeding and/or are very slow (5s+) on average. */
    Red
}