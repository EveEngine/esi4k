package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class CorporationStructure (
    @JsonProperty("corporation_id") val corporationId: Int,
    @JsonProperty("fuel_expires") val fuelExpires: String? = null,
    @JsonProperty("next_reinforce_apply") val nextReinforceApply: String? = null,
    @JsonProperty("next_reinforce_hour")  val nextReinforceHour: Int? = null,
    @JsonProperty("next_reinforce_weekday") val nextReinforceWeekday: Int? = null,
    @JsonProperty("profile_id") val profileId: Int,
    @JsonProperty("reinforce_hour") val reinforceHour: Int,
    @JsonProperty("reinforce_weekday") val reinforceWeekday: Int? = null,
    @JsonProperty("services") val services: List<Service>? = null,
    @JsonProperty("state") val state: StructureState,
    @JsonProperty("state_timer_end") val stateTimerEnd: String? = null,
    @JsonProperty("state_timer_start") val stateTimerStart: String? = null,
    @JsonProperty("structure_id") val structureId: Long,
    @JsonProperty("system_id") val systemId: Int,
    @JsonProperty("type_id") val typeId: Int,
    @JsonProperty("unanchors_at") val unanchorsAt: String? = null
 )

data class Service (
    @JsonProperty("name") val name: String,
    @JsonProperty("state") val state: ServiceState
)

enum class StructureState {
    AnchorVulnerable, Anchoring, ArmorReinforce, ArmorVulnerable, DeployVulnerable, FittingInvulnerable, HullReinforce, HullVulnerable, OnlineDeprecated, OnliningVulnerable, ShieldVulnerable, Unanchored, Unknown;
    companion object {
        @JsonCreator @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}

enum class ServiceState {
    Online, Offline, Cleanup
}