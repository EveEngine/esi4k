package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class IndustryJob (
        @JsonProperty("activity_id") val activityId: Int,
        @JsonProperty("blueprint_id") val blueprintId: Long,
        @JsonProperty("blueprint_location_id") val blueprintLocationId: Long,
        @JsonProperty("blueprint_type_id") val blueprintTypeId: Int,
        @JsonProperty("completed_character_id") val completedCharacterId: Int? = null,
        @JsonProperty("completed_date") val completedDate: String? = null,
        @JsonProperty("cost") val cost: Double? = null,
        @JsonProperty("duration") val duration: Int,
        @JsonProperty("end_date") val endDate: String,
        @JsonProperty("facility_id") val facilityId: Long,
        @JsonProperty("installer_id") val installerId: Int,
        @JsonProperty("job_id") val jobId: Int,
        @JsonProperty("licensed_runs") val licensedRuns: Int? = null,
        @JsonProperty("location_id") val location_id: Long? = null,
        @JsonProperty("output_location_id") val outputLocationId: Long,
        @JsonProperty("pause_date") val pauseDate: String? = null,
        @JsonProperty("probability") val probability: Float? = null,
        @JsonProperty("product_type_id") val productTypeId: Int? = null,
        @JsonProperty("runs") val runs: Int,
        @JsonProperty("start_date") val startDate: String,
        @JsonProperty("station_id") val stationId: Long,
        @JsonProperty("status") val status: JobStatus,
        @JsonProperty("successful_runs") val successfulRuns: Int? = null
)

enum class JobStatus {
    Active, Cancelled, Delivered, Paused, Ready, Reverted
}