package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Graphic (
        @JsonProperty("collision_file") val collisionFile: String? = null,
        @JsonProperty("graphic_file") val graphicFile: String? = null,
        @JsonProperty("graphic_id") val graphicId: Int,
        @JsonProperty("icon_folder") val iconFolder: String? = null,
        @JsonProperty("sof_dna") val sofDna: String? = null,
        @JsonProperty("sof_fation_name") val sofFationName: String? = null,
        @JsonProperty("sof_hull_name") val sofHullName: String? = null,
        @JsonProperty("sof_race_name") val sofRaceName: String? = null
)