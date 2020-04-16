package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Asset(
    @JsonProperty("is_blueprint_copy") val isBlueprintCopy: Boolean?,
    @JsonProperty("is_singleton") val isSingleton: Boolean,
    @JsonProperty("item_id") val itemId: Long,
    @JsonProperty("location_flag") val locationFlag: LocationFlag,
    @JsonProperty("location_id") val locationId: Long,
    @JsonProperty("location_type") val locationType: LocationType,
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("type_id") val typeId: Int
)

data class AssetLocation(
    @JsonProperty("item_id") val itemId: Long,
    @JsonProperty("position") val position: Position
)

data class AssetName(
    @JsonProperty("item_id") val itemId: Long,
    @JsonProperty("name") val name: String
)

enum class LocationFlag {
    AssetSafety, AutoFit, BoosterBay, Cargo, CorpseBay, Deliveries, DroneBay, FighterBay, FighterTube0, FighterTube1, FighterTube2, FighterTube3, FighterTube4, FleetHangar, FrigateEscapeBay, Hangar, HangarAll, HiSlot0, HiSlot1, HiSlot2, HiSlot3, HiSlot4, HiSlot5, HiSlot6, HiSlot7, HiddenModifiers, Implant, LoSlot0, LoSlot1, LoSlot2, LoSlot3, LoSlot4, LoSlot5, LoSlot6, LoSlot7, Locked, MedSlot0, MedSlot1, MedSlot2, MedSlot3, MedSlot4, MedSlot5, MedSlot6, MedSlot7, QuafeBay, RigSlot0, RigSlot1, RigSlot2, RigSlot3, RigSlot4, RigSlot5, RigSlot6, RigSlot7, ShipHangar, Skill, SpecializedAmmoHold, SpecializedCommandCenterHold, SpecializedFuelBay, SpecializedGasHold, SpecializedIndustrialShipHold, SpecializedLargeShipHold, SpecializedMaterialBay, SpecializedMediumShipHold, SpecializedMineralHold, SpecializedOreHold, SpecializedPlanetaryCommoditiesHold, SpecializedSalvageHold, SpecializedShipHold, SpecializedSmallShipHold, SubSystemBay, SubSystemSlot0, SubSystemSlot1, SubSystemSlot2, SubSystemSlot3, SubSystemSlot4, SubSystemSlot5, SubSystemSlot6, SubSystemSlot7, Unlocked, Wardrobe
}

enum class LocationType {
    Station, SolarSystem, Item, Other
}