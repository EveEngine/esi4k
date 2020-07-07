package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Item(
    @JsonProperty("item_id") val itemId: Int = 0,
    @JsonProperty("type_id") val typeId: Int = 0
)