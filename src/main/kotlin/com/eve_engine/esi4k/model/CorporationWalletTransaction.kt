package com.eve_engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CorporationWalletTransaction (
        @JsonProperty("client_id") val clientId: Int,
        @JsonProperty("date") val date: String,
        @JsonProperty("is_buy") val isBuy: Boolean,
        @JsonProperty("journal_ref_id") val journalRefId: Long,
        @JsonProperty("location_id") val locationId: Long,
        @JsonProperty("quantity") val quantity: Int,
        @JsonProperty("transaction_id") val transactionId: Long,
        @JsonProperty("type_id") val typeId: Int,
        @JsonProperty("unit_price")val unitPrice: Double
)