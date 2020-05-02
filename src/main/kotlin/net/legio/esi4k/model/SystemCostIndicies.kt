package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SystemCostIndicies (
        @JsonProperty("cost_indices") val costIndicies: List<CostIndex>,
        @JsonProperty("solar_system_id") val solarSystemId: Int
)

data class CostIndex (
        @JsonProperty("activity") val activity:  Activity,
        @JsonProperty("cost_index") val costIndex: Float
)

enum class Activity {
    Copying, Duplicating, Invention, Manufacturing, None, Reaction, ResearchingMaterialEfficiency, ResearchingTechnology, ResearchingTimeEfficiency, ReverseEngineering
}