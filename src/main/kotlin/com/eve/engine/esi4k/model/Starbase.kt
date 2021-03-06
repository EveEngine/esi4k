package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

open class Starbase (
    @JsonProperty("allow_alliance_members") val allowAllianceMembers: Boolean,
    @JsonProperty("allow_corporation_members") val allowCorporationMembers: Boolean,
    @JsonProperty("anchor") val anchor: Accessor,
    @JsonProperty("attack_if_at_war") val attackIfAtWar: Boolean,
    @JsonProperty("attack_if_other_security_status_dropping") val attackIfOtherSecurityStatusDropping: Boolean,
    @JsonProperty("attack_security_status_threshold") val attackSecurityStatusThreshold: Float? = null,
    @JsonProperty("attack_standing_threshold") val attackStandingThreshold: Float? = null,
    @JsonProperty("fuel_bay_take") val fuelBayTake: Accessor,
    @JsonProperty("fuel_bay_view") val fuelBayView: Accessor,
    @JsonProperty("fuels") val fuels: List<Fuel>? = null,
    @JsonProperty("offline") val offline: Accessor,
    @JsonProperty("online") val online: Accessor,
    @JsonProperty("unanchor") val unanchor: Accessor,
    @JsonProperty("use_alliance_standings") val useAllianceStanding: Boolean
)

open class Fuel (
    @JsonProperty("quantity") val quantity: Int,
    @JsonProperty("type_id") val typeId: Int
)

enum class Accessor {
    AllianceMember, ConfigStarbaseEquipmentRole, CorporationMember, StarbaseFuelTechnicianRole;

    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}