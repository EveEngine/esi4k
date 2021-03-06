package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class OpportunityTask (
        @JsonProperty("description") val description: String,
        @JsonProperty("name") val name: String,
        @JsonProperty("notification") val notification: String,
        @JsonProperty("task_id") val taskId: Int
)