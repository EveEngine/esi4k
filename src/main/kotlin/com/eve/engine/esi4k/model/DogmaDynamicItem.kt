package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSetter

data class DogmaDynamicItem (
    @JsonProperty("created_by") val createdBy: Int,
    @JsonProperty("dogma_attributes") val dogmaAttributes: List<DogmaAttributeReference>,
    @JsonProperty("dogma_effects") val dogmaEffects: List<DogmaEffectsReference>,
    @JsonProperty("mutator_type_id") val mutatorTypeId: Int,
    @JsonProperty("source_type_id") val sourceTypeId: Int
)

data class DogmaAttributeReference (
    @JsonProperty("attribute_id") val attributeId: Int,
    @JsonProperty("value") val value: Float
)

data class DogmaEffectsReference(
    @JsonProperty("effect_id") val effectId: Int,
    @JsonProperty("is_default") val isDefault: Boolean
)
