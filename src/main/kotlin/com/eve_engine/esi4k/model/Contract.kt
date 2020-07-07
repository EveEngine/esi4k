package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class Contract(
    @JsonProperty("acceptor_id") val acceptorId: Int,
    @JsonProperty("assignee_id") val assigneeId: Int,
    @JsonProperty("availability") val availability: ContractAvailability,
    @JsonProperty("buyout")  buyout: Double? = null,
    @JsonProperty("collateral")  collateral: Double? = null,
    @JsonProperty("contract_id")  contractId: Int,
    @JsonProperty("date_accepted") val dateAccepted: String? = null,
    @JsonProperty("date_completed") val dateCompleted: String? = null,
    @JsonProperty("date_expired")  dateExpired: String,
    @JsonProperty("date_issued")  dateIssued: String,
    @JsonProperty("days_to_complete")  daysToComplete: Int? = null,
    @JsonProperty("end_location_id")  endLocationId: Long? = null,
    @JsonProperty("for_corporation")  forCorporation: Boolean,
    @JsonProperty("issuer_corporation_id")  issuerCorporationId: Int,
    @JsonProperty("issuer_id")  issuerId: Int,
    @JsonProperty("price")  price: Double? = null,
    @JsonProperty("reward")  reward: Double? = null,
    @JsonProperty("start_location_id")  startLocationId: Long? = null,
    @JsonProperty("status")  status: ContractStatus,
    @JsonProperty("title")  title: String? = null,
    @JsonProperty("type")  type: ContractType,
    @JsonProperty("volume")  volume: Double? = null
): PublicContract (
    buyout, collateral, contractId, dateExpired, dateIssued, daysToComplete, endLocationId, forCorporation, issuerCorporationId, issuerId, price, reward, startLocationId, title, type
)

enum class ContractAvailability {
    Public, Personal, Corporation, Alliance
}

enum class ContractStatus {
    Outstanding, InProgress, FinishedIssuer, FinishedContractor, Finished, Cancelled, Rejected, Failed, Deleted, Reversed
}

enum class ContractType {
    Unknown, ItemExchange, Auction, Courier, Loan;

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}