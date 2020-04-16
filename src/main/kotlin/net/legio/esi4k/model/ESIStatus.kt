package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter

/**
 *  Status of an Eve ESI route.
 */
class ESIStatus {
    enum class Status {
        /** Good. */
        GREEN,
        /** Degraded, meaning slow or potentially dropping requests. */
        YELLOW,
        /** Most requests are not succeeding and/or are very slow (5s+) on average. */
        RED
    }

    @JsonProperty("endpoint")
    lateinit var endpoint: String

    @JsonProperty("method")
    lateinit var method: String

    @JsonProperty("route")
    lateinit var route: String

    lateinit var status: Status

    @JsonSetter
    private fun status(value: String){
        status = Status.valueOf(value.toUpperCase())
    }

    @JsonProperty("tags")
    lateinit var tags: Array<String>
}