package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class MiningObserver (
        @JsonProperty("last_updated") val lastUpdate: String,
        @JsonProperty("observer_id") val observerId: Long,
        @JsonProperty("observer_type") val observerType: ObserverType
)

enum class ObserverType {
    Structure
}