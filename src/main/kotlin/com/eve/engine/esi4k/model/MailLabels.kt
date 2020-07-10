package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonProperty

open class MailLabels (
        @JsonProperty("labels") val labels: List<MailLabel>? = null,
        @JsonProperty("total_unread_count") val totalUnreadCount: Int? = null
)

open class MailLabel(
        @JsonProperty("color") val color: LabelColor? = null,
        @JsonProperty("label_id") val labelId: Int? = null,
        @JsonProperty("name") val name: String? = null,
        @JsonProperty("unread_count") val unreadCount: Int? = null
)

enum class LabelColor(val value: String) {
    Blue("#0000fe"),
    LightBlue("#0099ff"),
    Green("#006634"),
    LightGreen("#349800"),
    Cyan("#01ffff"),
    LightCyan("#99ffff"),
    Purple("#660066"),
    Gray("#999999"),
    DarkGray("#666666"),
    LightGray("#e6e6e6"),
    Lime("#ccff9a"),
    LightLime("#00ff33"),
    Red("#fe0000"),
    Orange("#ff6600"),
    Yellow("#ffff01"),
    LightYellow("#ffffcd"),
    White("#ffffff");

    @JsonGetter
    fun serialize() = value

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}