package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Item(
    @JsonProperty("item_id") val itemId: Int = 0,
    @JsonProperty("type_id") val typeId: Int = 0
)