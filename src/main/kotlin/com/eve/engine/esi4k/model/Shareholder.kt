package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class Shareholder (
    @JsonProperty("share_count") val shareCount: Long,
    @JsonProperty("shareholder_id") val shareholderId: Int,
    @JsonProperty("shareholder_type") val shareholderType: ShareholderType
)

enum class ShareholderType {
    Character, Corporation
}