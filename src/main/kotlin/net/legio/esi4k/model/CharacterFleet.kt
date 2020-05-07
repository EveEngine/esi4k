package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterFleet (
        @JsonProperty("fleet_id") val fleetId: Long,
        @JsonProperty("role") val role: FleetRole,
        @JsonProperty("squad_id") val squadId: Long,
        @JsonProperty("wing_id") val wingId: Long
)

enum class FleetRole {
    FleetCommander, SquadCommander, SquadMember, WingCommander;

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}