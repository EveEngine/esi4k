package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

open class CharacterFleet (
        @JsonProperty("fleet_id") val fleetId: Long,
        @JsonProperty("role") val role: FleetRole,
        @JsonProperty("squad_id") val squadId: Long,
        @JsonProperty("wing_id") val wingId: Long
)

enum class FleetRole(val value: String) {
    FleetCommander("fleet_commander"),
    SquadCommander("squad_commander"),
    SquadMember("squad_member"),
    WingCommander("wing_commander");

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}