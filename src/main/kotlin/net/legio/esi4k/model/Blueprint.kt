package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Blueprint(
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("material_efficiency") val materialEfficiency: Int,
    @JsonProperty("item_id") val itemId: Long,
    @JsonProperty("location_flag") val locationFlag: LocationFlag,
    @JsonProperty("time_efficiency") val timeEfficiency: Int,
    @JsonProperty("type_id") val typeId: Int,
    @JsonProperty("runs") val runs: Int,
    @JsonProperty("location_id") val locationId: Int
)