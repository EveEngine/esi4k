package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SkillQueue (
        @JsonProperty("finish_date") val finishDate: String? = null,
        @JsonProperty("finished_level") val finishedLevel: Int,
        @JsonProperty("level_end_sp") val levelEndSp: Int? = null,
        @JsonProperty("level_start_sp") val levelStartSp: Int? = null,
        @JsonProperty("queue_position") val queuePosition: Int,
        @JsonProperty("skill_id") val skillId: Int,
        @JsonProperty("start_date") val startDate: String? = null,
        @JsonProperty("training_start_sp") val trainingStartSp: String? = null
)