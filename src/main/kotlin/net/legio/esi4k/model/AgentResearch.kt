package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class AgentResearch(
    @JsonProperty("remainder_points") val remainderPoints: Float,
    @JsonProperty("agent_id") val agentId: Int,
    @JsonProperty("skill_type_id") val skillTypeId: Int,
    @JsonProperty("started_at") val startedAt: String,
    @JsonProperty("points_per_day") val pointsPerDay: Float
)