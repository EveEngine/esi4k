package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class ColonyLayout (
        @JsonProperty("links") val links: List<Link>,
        @JsonProperty("pins") val pins: List<Pin>,
        @JsonProperty("routes") val routes: List<Route>
)

open class Link (
        @JsonProperty("destination_pin_id") val destinationPinId: Long,
        @JsonProperty("link_level") val linkLevel: Int,
        @JsonProperty("source_pin_id") val sourcePinId: Long
)

open class Pin (
        @JsonProperty("contents") val contents: List<PinContent>? = null,
        @JsonProperty("expiry_time") val expiryTime: String? = null,
        @JsonProperty("extractor_details") val extractorDetails: List<ExtractorDetails>,
        @JsonProperty("factory_details") val factoryDetails: List<FactoryDetails>,
        @JsonProperty("install_time") val installTime: String? = null,
        @JsonProperty("last_cycle_state") val lastCycleStart: String? = null,
        @JsonProperty("latitude") val latitude: Float,
        @JsonProperty("longitude") val longitude: Float,
        @JsonProperty("pin_id") val pinId: Long,
        @JsonProperty("schematic_id") val schematicId: Int? = null,
        @JsonProperty("type_id") val typeId: Int
)

open class PinContent (
        @JsonProperty("amount") val amount: Long,
        @JsonProperty("type_id") val typeId: Int
)

open class ExtractorDetails (
        @JsonProperty("cycle_time") val cycleTime: Int? = null,
        @JsonProperty("head_radius") val headRadius: Float? = null,
        @JsonProperty("heads") val heads: List<Head>,
        @JsonProperty("product_type_id") val productTypeId: Int? = null,
        @JsonProperty("qty_per_cycle") val qtyPerCycle: Int
)

open class Head (
        @JsonProperty("head_id") val headId: Int,
        @JsonProperty("latitude") val latitude: Float,
        @JsonProperty("longitude") val longitude: Float
)

open class FactoryDetails (
        @JsonProperty("schematic_id") val schematicId: Int
)

open class Route (
        @JsonProperty("content_type_id") val contentTypeId: Int,
        @JsonProperty("destination_pin_id") val destinationPinId: Long,
        @JsonProperty("quantity") val quantity: Float,
        @JsonProperty("route_id") val routeId: Long,
        @JsonProperty("source_pin_id") val sourcePinId: Long,
        @JsonProperty("waypoints") val waypoints: List<Long>? = null
)