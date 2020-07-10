package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

open class SystemCostIndicies (
        @JsonProperty("cost_indices") val costIndicies: List<CostIndex>,
        @JsonProperty("solar_system_id") val solarSystemId: Int
)

open class CostIndex (
        @JsonProperty("activity") val activity:  Activity,
        @JsonProperty("cost_index") val costIndex: Float
)

enum class Activity {
    Copying, Duplicating, Invention, Manufacturing, None, Reaction, ResearchingMaterialEfficiency, ResearchingTechnology, ResearchingTimeEfficiency, ReverseEngineering;

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}