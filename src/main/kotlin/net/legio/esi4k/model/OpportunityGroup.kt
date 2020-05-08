package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class OpportunityGroup (
    @JsonProperty("connected_groups") val connectedGroups: List<Int>,
    @JsonProperty("description") val description: String,
    @JsonProperty("group_id") val groupId: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("notification") val notification: String,
    @JsonProperty("required_tasks") val requiredTasks: List<Int>
)