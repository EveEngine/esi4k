package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SolarSystem (
        @JsonProperty("constellation_id") val constellationId: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("planets") val planets: List<SystemPlanet>,
        @JsonProperty("position") val position: Position,
        @JsonProperty("security_class") val securityClass: String? = null,
        @JsonProperty("security_status") val securityStatus: Float,
        @JsonProperty("star_id") val starId: Int? = null,
        @JsonProperty("stargates") val stargates: List<Int>? = null,
        @JsonProperty("stations") val stations: List<Int>? = null,
        @JsonProperty("system_id") val systemId: Int
)

data class SystemPlanet (
        @JsonProperty("asteroid_belts") val asteroidBelts: List<Int>? = null,
        @JsonProperty("moons") val moons: List<Int>? = null,
        @JsonProperty("planet_id") val planetId: Int
)