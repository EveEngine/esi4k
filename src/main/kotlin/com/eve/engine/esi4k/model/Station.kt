package com.eve.engine.esi4k.model


import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

open class Station(
        @JsonProperty("owner") val owner: Int? = null,
        @JsonProperty("reprocessing_efficiency") val reprocessingEfficiency: Double,
        @JsonProperty("office_rental_cost") val officeRentalCost: Int,
        @JsonProperty("system_id") val systemId: Int,
        @JsonProperty("type_id") val typeId: Int,
        @JsonProperty("race_id") val raceId: Int? = null,
        @JsonProperty("station_id") val stationId: Int,
        @JsonProperty("max_dockable_ship_volume") val maxDockableShipVolume: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("position") val position: Position,
        @JsonProperty("services") val services: List<StationService>?,
        @JsonProperty("reprocessing_stations_take") val reprocessingStationsTake: Double
)

enum class StationService {
    BountyMissions, AssasinationMissions, CourierMissions, Interbus, ReprocessingPlant, Refinery, Market, BlackMarket, StockExchange, Cloning, Surgery, DNATherapy, RepairFacilities, Factory, Labratory, Gambling, Fitting, Paintshop, News, Storage, Insurance, Docking, OfficeRental, JumpCloneFacility, LoyaltyPointStore, NavyOffices, SecurityOffices;

    companion object {
        @JsonCreator@JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("-", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}