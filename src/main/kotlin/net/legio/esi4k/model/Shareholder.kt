package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Shareholder (
    @JsonProperty("share_count") val shareCount: Long,
    @JsonProperty("shareholder_id") val shareholderId: Int,
    @JsonProperty("shareholder_type") val shareholderType: ShareholderType
)

enum class ShareholderType {
    Character, Corporation
}