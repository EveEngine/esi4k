package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CharacterStats(
    @JsonProperty("days_of_inactivity") val daysOfInactivity: Long? = null,
    @JsonProperty("minutes") val minutes: Long? = null,
    @JsonProperty("sessions_started") val sessionsStarted: Long? = null
)

data class CombatStats(
    @JsonProperty("cap_drainby_npc") val capDrainByNPC: Long? = null,
    @JsonProperty("cap_drainby_pc") val capDrainByPC: Long? = null,
    @JsonProperty("cap_daring_pc") val capDrainingPC: Long? = null,
    @JsonProperty("criminal_flag_set") val criminalFlagSet: Long? = null,
    @JsonProperty("damage_from_np_cs_amount") val damageFromNPCSAmoun: Long? = null,
    @JsonProperty("damage_from_np_cs_num_shots") val damageFromNPCSNumShots: Long? = null
)