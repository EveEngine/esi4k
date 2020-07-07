package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Asset(
    @JsonProperty("is_blueprint_copy") val isBlueprintCopy: Boolean?,
    @JsonProperty("is_singleton") val isSingleton: Boolean,
    @JsonProperty("item_id") val itemId: Long,
    @JsonProperty("location_flag") val locationFlag: LocationFlag,
    @JsonProperty("location_id") val locationId: Long,
    @JsonProperty("location_type") val locationType: LocationType,
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("type_id") val typeId: Int
)

data class AssetLocation(
    @JsonProperty("item_id") val itemId: Long,
    @JsonProperty("position") val position: Position
)

data class AssetName(
    @JsonProperty("item_id") val itemId: Long,
    @JsonProperty("name") val name: String
)