package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterShip (
        @JsonProperty("ship_item_id") val shipItemId: Long,
        @JsonProperty("ship_name") val shipName: String,
        @JsonProperty("ship_type_id") val shipId: Int
)