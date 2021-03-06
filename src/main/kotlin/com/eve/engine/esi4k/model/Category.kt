package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Category (
        @JsonProperty("category_id") val categoryId: Int,
        @JsonProperty("groups") val groups: List<Int>,
        @JsonProperty("name") val name: String,
        @JsonProperty("published") val published: Boolean
)