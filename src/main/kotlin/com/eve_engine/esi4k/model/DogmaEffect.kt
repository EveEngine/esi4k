package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class DogmaEffect (
    @JsonProperty("description") val description: String? = null,
    @JsonProperty("disallow_auto_repeat") val disallowAutoRepeat: Boolean? = null,
    @JsonProperty("discharge_attribute_id") val dischargeAttributeId: Int? = null,
    @JsonProperty("display_name") val displayName: String? = null,
    @JsonProperty("duration_attribute_id") val durationAttributeId: Int? = null,
    @JsonProperty("effect_category") val effectCategory: Int? = null,
    @JsonProperty("effect_id") val effectId: Int,
    @JsonProperty("electronic_chance") val electronicChange: Boolean? = null,
    @JsonProperty("falloff_attribute_id") val falloffAttributeId: Int? = null,
    @JsonProperty("icon_id") val iconId: Int? = null,
    @JsonProperty("is_assistance") val isAssistance: Boolean? = null,
    @JsonProperty("is_offensive") val isOffensive: Boolean? = null,
    @JsonProperty("is_warp_safe") val isWarpSafe: Boolean? = null,
    @JsonProperty("modifiers") val modifiers: List<EffectModifier>? = null,
    @JsonProperty("name") val name: String? = null,
    @JsonProperty("post_expression") val postExpressions: Int? = null,
    @JsonProperty("pre_expression") val preExpression: Int? = null,
    @JsonProperty("published") val published: Boolean? = null,
    @JsonProperty("range_attribute_id") val rangeAttributeId: Int? = null,
    @JsonProperty("range_chance") val rangeChange: Boolean? = null,
    @JsonProperty("tracking_speed_attribute_id") val trackingSpeedAttributeId: Int? = null
)