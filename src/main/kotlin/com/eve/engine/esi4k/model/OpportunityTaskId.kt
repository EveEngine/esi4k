package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class OpportunityTaskId (
        @JsonProperty("completed_at") val completedAt: String,
        @JsonProperty("task_id") val taskId: Int
)