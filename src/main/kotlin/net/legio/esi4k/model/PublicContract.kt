package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class PublicContract(
    @JsonProperty("buyout") val buyout: Double? = null,
    @JsonProperty("collateral") val collateral: Double? = null,
    @JsonProperty("contract_id") val contractId: Int,
    @JsonProperty("date_expired") val dateExpired: String,
    @JsonProperty("date_issued") val dateIssued: String,
    @JsonProperty("days_to_complete") val daysToComplete: Int? = null,
    @JsonProperty("end_location_id") val endLocationId: Long? = null,
    @JsonProperty("for_corporation") val forCorporation: Boolean,
    @JsonProperty("issuer_corporation_id") val issuerCorporationId: Int,
    @JsonProperty("issuer_id") val issuerId: Int,
    @JsonProperty("price") val price: Double? = null,
    @JsonProperty("reward") val reward: Double? = null,
    @JsonProperty("start_location_id") val startLocationId: Long? = null,
    @JsonProperty("title") val title: String? = null,
    @JsonProperty("type") val type: ContractType,
    @JsonProperty("volume") val volume: Double? = null
)