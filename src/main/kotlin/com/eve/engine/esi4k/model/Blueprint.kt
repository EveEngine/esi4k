package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Blueprint(
    @JsonProperty("item_id") val itemId: Long,
    @JsonProperty("location_flag") val locationFlag: LocationFlag,
    @JsonProperty("location_id") val locationId: Int,
    @JsonProperty("material_efficiency") val materialEfficiency: Int,
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("runs") val runs: Int,
    @JsonProperty("time_efficiency") val timeEfficiency: Int,
    @JsonProperty("type_id") val typeId: Int
)