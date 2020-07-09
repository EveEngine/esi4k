package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ItemGroup(
        @JsonProperty("types") val types: List<Int>,
        @JsonProperty("category_id") val categoryId: Int,
        @JsonProperty("group_id") val groupId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("published") val published: Boolean
)