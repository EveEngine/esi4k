package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty


data class PublicContractItem (
    @JsonProperty("is_blueprint_copy") val isBlueprintCopy: Boolean? = null,
    @JsonProperty("is_included") val isIncluded: Boolean,
    @JsonProperty("item_id") val itemId: Long? = null,
    @JsonProperty("material_efficiency") val materialEfficiency: Int? = null,
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("record_id") val recordId: Long,
    @JsonProperty("runs") val runs: Int? = null,
    @JsonProperty("time_efficiency") val timeEfficiency: Int? = null,
    @JsonProperty("type_id") val typeId: Int
)