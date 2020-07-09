package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Type(
        @JsonProperty("group_id") val groupId: Int,
        @JsonProperty("type_id") val typeId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("description") val description: String,
        @JsonProperty("published") val published: Boolean,
        @JsonProperty("capacity") val capacity: Float? = null,
        @JsonProperty("dogma_attributes") val dogmaAttributes: List<TypeDogmaAttribute>? = null,
        @JsonProperty("dogma_effects") val dogmaEffects: List<TypeDogmaEffect>? = null,
        @JsonProperty("graphic_id") val graphicId: Int? = null,
        @JsonProperty("icon_id") val iconId: Int? = null,
        @JsonProperty("market_group_id") val marketGroupId: Int? = null,
        @JsonProperty("mass") val mass: Float? = null,
        @JsonProperty("packaged_volume") val packagedVolume: Float? = null,
        @JsonProperty("portion_size") val portionSize: Int? = null,
        @JsonProperty("radius") val radius: Float? = null,
        @JsonProperty("volume") val volume: Float? = null
)

data class TypeDogmaAttribute(
        @JsonProperty("attribute_id") val attributeId: Int,
        @JsonProperty("value") val value: Float
)

data class TypeDogmaEffect (
        @JsonProperty("effect_id") val effectId: Int,
        @JsonProperty("is_default") val isDefault: Boolean
)