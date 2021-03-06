package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

open class MiningObserver (
        @JsonProperty("last_updated") val lastUpdate: String,
        @JsonProperty("observer_id") val observerId: Long,
        @JsonProperty("observer_type") val observerType: ObserverType
)

enum class ObserverType {
    Structure
}