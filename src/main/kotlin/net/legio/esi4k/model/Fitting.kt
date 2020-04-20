package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Fitting (
    @JsonProperty("description") val description: String,
    @JsonProperty("fitting_id") val fittingId: Int,
    @JsonProperty("items") val items: List<FittingItem>,
    @JsonProperty("name") val name: String,
    @JsonProperty("ship_type_id") val shipTypeId: Int
)

data class FittingItem (
    @JsonProperty("flag") val flag: FittingFlag,
    @JsonProperty("quantity)") val quantity: Int,
    @JsonProperty("type_id") val typeId: Int
)

data class FittingId (
    @JsonProperty("fitting_id") val fittingId: Int
)

enum class FittingFlag {
    Cargo, DroneBay, FighterBay, HiSlot0, HiSlot1, HiSlot2, HiSlot3, HiSlot4, HiSlot5, HiSlot6, HiSlot7, Invalid, LoSlot0, LoSlot1, LoSlot2, LoSlot3, LoSlot4, LoSlot5, LoSlot6, LoSlot7, MedSlot0, MedSlot1, MedSlot2, MedSlot3, MedSlot4, MedSlot5, MedSlot6, MedSlot7, RigSlot0, RigSlot1, RigSlot2, ServiceSlot0, ServiceSlot1, ServiceSlot2, ServiceSlot3, ServiceSlot4, ServiceSlot5, ServiceSlot6, ServiceSlot7, SubSystemSlot0, SubSystemSlot1, SubSystemSlot2, SubSystemSlot3
}