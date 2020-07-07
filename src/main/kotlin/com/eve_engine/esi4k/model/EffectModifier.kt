package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class EffectModifier (
    @JsonProperty("domain") val domain: String? = null,
    @JsonProperty("effect_id") val effectId: Int? = null,
    @JsonProperty("func") val func: String,
    @JsonProperty("modified_attribute_id") val modifiedAttributeId: Int? = null,
    @JsonProperty("modifying_attribute_id") val modifyingAttributeId: Int? = null,
    @JsonProperty("operator") val operator: Int? = null
)