package net.legio.esi4k.model.internal

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import net.legio.esi4k.model.LabelColor

data class NewMailLabel (
        @JsonProperty("color") val labelColor: LabelColor? = null,
        @JsonProperty("name") val name: String
)