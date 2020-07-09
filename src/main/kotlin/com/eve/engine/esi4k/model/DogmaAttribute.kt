package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class DogmaAttribute (
    @JsonProperty("attribute_id") val attributeId: Int,
    @JsonProperty("default_value") val defaultValue: Float? = null,
    @JsonProperty("description") val description: String? = null,
    @JsonProperty("display_name") val displayName: String? = null,
    @JsonProperty("high_is_good") val highIsGood: Boolean? = null,
    @JsonProperty("icon_id") val iconId: Int? = null,
    @JsonProperty("name") val name: String? = null,
    @JsonProperty("published") val published: Boolean? = null,
    @JsonProperty("stackable") val stackable: Boolean? = null,
    @JsonProperty("unit_id") val unitId: Int? = null
)