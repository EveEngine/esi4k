package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Colony (
        @JsonProperty("last_update") val lastUpdate: String,
        @JsonProperty("num_pins") val numPins: Int,
        @JsonProperty("owner_id") val ownerId: Int,
        @JsonProperty("planet_id") val planetId: Int,
        @JsonProperty("planet_type") val planetType: PlanetType,
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("upgrade_level") val upgradeLevel: Int

)

enum class PlanetType {
    Temperate, Barren, Oceanic, Ice, Gas, Lava, Storm, Plasma
}