package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

class ContractBid (
    @JsonProperty("amount") amount: Float,
    @JsonProperty("bid_id") bidId: Int,
    @JsonProperty("bidder_id") val bidderId: Int,
    @JsonProperty("date_bid") dateBid: String
): PublicContractBid(amount, bidId, dateBid)

open class PublicContractBid (
    @JsonProperty("amount") val amount: Float,
    @JsonProperty("bid_id") val bidId: Int,
    @JsonProperty("date_bid") val dateBid: String
)