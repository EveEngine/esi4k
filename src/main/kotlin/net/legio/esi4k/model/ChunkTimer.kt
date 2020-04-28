package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ChunkTimer (
        @JsonProperty("chunk_arrival_time") val chuckArrivalTime: String,
        @JsonProperty("extraction_start_time") val extractionStartTime: String,
        @JsonProperty("moon_id") val moonId: Int,
        @JsonProperty("natural_decay_time") val naturalDecayTime: String,
        @JsonProperty("structure_id") val structureId: Long
)