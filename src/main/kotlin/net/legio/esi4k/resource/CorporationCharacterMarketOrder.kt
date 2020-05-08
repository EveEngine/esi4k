package net.legio.esi4k.resource

import com.fasterxml.jackson.annotation.JsonProperty
import net.legio.esi4k.model.CharacterMarketOrder

class CorporationCharacterMarketOrder(
        @JsonProperty("duration") duration: Int,
        @JsonProperty("escrow") escrow: Double? = null,
        @JsonProperty("is_buy_order") isBuyOrder: Boolean? = null,
        @JsonProperty("is_corporation") isCorporation: Boolean,
        @JsonProperty("issued") issued: String,
        @JsonProperty("location_id") locationId: Long,
        @JsonProperty("min_volume") minVolume: Int? = null,
        @JsonProperty("order_id") orderId: Long,
        @JsonProperty("price") price: Double,
        @JsonProperty("range") range: String,
        @JsonProperty("region_id") regionId: Int,
        @JsonProperty("type_id") typeId: Int,
        @JsonProperty("volume_remain") volumeRemain: Int,
        @JsonProperty("volume_total") volumeTotal: Int,
        @JsonProperty("wallet_division") val walletDivision: Int
): CharacterMarketOrder(
        duration, escrow, isBuyOrder, isCorporation, issued, locationId, minVolume, orderId, price, range, regionId, typeId, volumeRemain, volumeTotal
)