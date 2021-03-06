package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CharacterYearStats (
    @JsonProperty("character") val character: CharacterStats? = null
)

open class CharacterStats(
    @JsonProperty("days_of_inactivity") val daysOfInactivity: Long? = null,
    @JsonProperty("minutes") val minutes: Long? = null,
    @JsonProperty("sessions_started") val sessionsStarted: Long? = null
)

open class CombatStats(
    @JsonProperty("cap_drainedby_npc") val capDrainByNPC: Long? = null,
    @JsonProperty("cap_drainedby_pc") val capDrainByPC: Long? = null,
    @JsonProperty("cap_draining_pc") val capDrainingPC: Long? = null,
    @JsonProperty("criminal_flag_set") val criminalFlagSet: Long? = null,
    @JsonProperty("damage_from_np_cs_amount") val damageFromNPCSAmount: Long? = null,
    @JsonProperty("damage_from_np_cs_num_shots") val damageFromNPCSNumShots: Long? = null,
    @JsonProperty("damage_from_players_bomb_amount") val damageFromPlayersBombAmount: Long? = null,
    @JsonProperty("damage_from_players_bomb_num_shots") val damageFromPlayersBombNumShots: Long? = null,
    @JsonProperty("damage_from_players_combat_drone_amount") val damageFromPlayersCombatDroneAmount: Long? = null,
    @JsonProperty("damage_from_players_combat_drone_num_shots") val damageFromPlayersCombatDroneNumShots: Long? = null,
    @JsonProperty("damage_from_players_energy_amount") val damageFromPlayersEnergyAmount: Long? = null,
    @JsonProperty("damage_from_players_energy_num_shots") val damageFromPlayersEnergyNumShots: Long? = null,
    @JsonProperty("damage_from_players_fighter_bomber_amount") val damageFromPlayersFighterBomberAmount: Long? = null,
    @JsonProperty("damage_from_players_fighter_bomber_num_shots") val damageFromPlayersFighterBomberNumShots: Long? = null,
    @JsonProperty("damage_from_players_fighter_drone_amount") val damageFromPlayersFighterDroneAmount: Long? = null,
    @JsonProperty("damage_from_players_fighter_drone_num_shots") val damageFromPlayersFighterDroneNumShots: Long? = null,
    @JsonProperty("damage_from_players_hybrid_amount") val damageFromPlayersHybridAmount: Long? = null,
    @JsonProperty("damage_from_players_hybrid_num_shots") val damageFromPlayersHybridNumShots: Long? = null,
    @JsonProperty("damage_from_players_missile_amount") val damageFromPlayersMissileAmount: Long? = null,
    @JsonProperty("damage_from_players_missile_num_shots") val damageFromPlayersMissileNumShots: Long? = null,
    @JsonProperty("damage_from_players_projectile_amount") val damageFromPlayersProjectileAmount: Long? = null,
    @JsonProperty("damage_from_players_projectile_num_shots") val damageFromPlayersProjectileNumShots: Long? = null,
    @JsonProperty("damage_from_players_smart_bomb_amount") val damageFromPlayersSmartBombAmount: Long? = null,
    @JsonProperty("damage_from_players_smart_bomb_num_shots") val damageFromPlayersSmartBombNumShots: Long? = null,
    @JsonProperty("damage_from_players_super_amount") val damageFromPlayersSuperAmount: Long? = null,
    @JsonProperty("damage_from_players_super_num_shots") val damageFromPlayersSuperNumShots: Long? = null,
    @JsonProperty("damage_from_structures_total_amount") val damageFromStructuresTotalAmount: Long? = null,
    @JsonProperty("damage_from_structures_total_num_shots") val damageFromStructuresNumShots: Long? = null,
    @JsonProperty("damage_to_players_bomb_amount") val damageToPlayersBombAmount: Long? = null,
    @JsonProperty("damage_to_players_bomb_num_shots") val damageToPlayersBombNumShots: Long? = null,
    @JsonProperty("damage_to_players_combat_drone_amount") val damageToPlayersCombatDroneAmount: Long? = null,
    @JsonProperty("damage_to_players_combat_drone_num_shots") val damageToPlayersCombatDronesNumShots: Long? = null,
    @JsonProperty("damage_to_players_energy_amount") val damageToPlayersEnergyAmount: Long? = null,
    @JsonProperty("damage_to_players_energy_num_shots") val damageToPlayersEnergyNumShots: Long? = null,
    @JsonProperty("damage_to_players_fighter_bomber_amount") val damageToPlayersFighterBomberAmount: Long? = null,
    @JsonProperty("damage_to_players_fighter_bomber_num_shots") val damageToPlayersFighterBomberNumShots: Long? = null,
    @JsonProperty("damage_to_players_fighter_drone_amount") val damageToPlayersFighterDroneAmount: Long? = null,
    @JsonProperty("damage_to_players_fighter_drone_num_shots") val damageToPlayersFighterDroneNumShots: Long? = null,
    @JsonProperty("damage_to_players_hybrid_amount") val damageToPlayersHybridAmount: Long? = null,
    @JsonProperty("damage_to_players_hybrid_num_shots") val damageToPlayersHybridNumShots: Long? = null,
    @JsonProperty("damage_to_players_missile_amount") val damageToPlayersMissileAmount: Long? = null,
    @JsonProperty("damage_to_players_missile_num_shots") val damageToPlayersMissileNumShots: Long? = null,
    @JsonProperty("damage_to_players_projectile_amount") val damageToPlayersProjectileAmount: Long? = null,
    @JsonProperty("damage_to_players_projectile_num_shots") val damageToPlayersProjectileNumShots: Long? = null,
    @JsonProperty("damage_to_players_smart_bomb_amount") val damageToPlayersSmartBombAmount: Long? = null,
    @JsonProperty("damage_to_players_smart_bomb_num_shots") val damageToPlayersSmartBombNumShots: Long? = null,
    @JsonProperty("damage_to_players_super_amount") val damageToPlayersSuperAmount: Long? = null,
    @JsonProperty("damage_to_players_super_num_shots") val damageToPlayersSuperNumShots: Long? = null,
    @JsonProperty("damage_to_structures_total_amount") val damageToStructuresTotalAmount: Long? = null,
    @JsonProperty("damage_to_structures_total_num_shots") val damageToStructuresNumShots: Long? = null,
    @JsonProperty("deaths_high_sec") val deathsHighSec: Long? = null,
    @JsonProperty("deaths_low_sec") val deathsLowSec: Long? = null,
    @JsonProperty("deaths_null_sec") val deathsNullSec: Long? = null,
    @JsonProperty("deaths_pod_high_sec") val deathsPodHighSec: Long? = null,
    @JsonProperty("deaths_pod_low_sec") val deathsPodLowSec: Long? = null,
    @JsonProperty("deaths_pod_null_sec") val deathsPodNullSec: Long? = null,
    @JsonProperty("deaths_pod_wormhole") val deathsPodWormhole: Long? = null,
    @JsonProperty("deaths_wormhole") val deathsWormhole: Long? = null,
    @JsonProperty("drone_engage") val droneEngage: Long? = null,
    @JsonProperty("dscans") val dscans: Long? = null,
    @JsonProperty("duel_requested") val dualRequested: Long? = null,
    @JsonProperty("engagement_register") val engagementRegister: Long? = null,
    @JsonProperty("kills_assists") val killsAssists: Long? = null,
    @JsonProperty("kills_high_sec") val killsHighSec: Long? = null,
    @JsonProperty("kills_low_sec") val killsLowSec: Long? = null,
    @JsonProperty("kills_null_sec") val killsNullSec: Long? = null,
    @JsonProperty("kills_pod_high_sec") val killsPodHighSec: Long? = null,
    @JsonProperty("kills_pod_low_sec") val killsPodLowSec: Long? = null,
    @JsonProperty("kills_pod_null_sec") val killsPodNullSec: Long? = null,
    @JsonProperty("kills_pod_wormhole") val killsPodWormhole: Long? = null,
    @JsonProperty("kills_wormhole") val killsWormhole: Long? = null,
    @JsonProperty("npc_flag_set") val npcFlagSet: Long? = null,
    @JsonProperty("probe_scans") val probeScans: Long? = null,
    @JsonProperty("pvp_flag_set") val pvpFlagSet: Long? = null,
    @JsonProperty("repair_armor_by_remote_amount") val repairArmorByRemoteAmount: Long? = null,
    @JsonProperty("repair_armor_remote_amount") val repairArmorRemoteAmount: Long? = null,
    @JsonProperty("repair_armor_self_amount") val repairArmorSelfAmount: Long? = null,
    @JsonProperty("repair_capacitor_by_remote_amount") val repairCapacitorByRemoteAmount: Long? = null,
    @JsonProperty("repair_capacitor_remote_amount") val repairCapacitorRemoteAmount: Long? = null,
    @JsonProperty("repair_capacitor_self_amount") val repairCapacitorSelfAmount: Long? = null,
    @JsonProperty("repair_hull_by_remote_amount") val repairHullByRemoteAmount: Long? = null,
    @JsonProperty("repair_hull_remote_amount") val repairHullRemoteAmount: Long? = null,
    @JsonProperty("repair_hull_self_amount") val repairHullSelfAmount: Long? = null,
    @JsonProperty("repair_shield_by_remote_amount") val repairShieldByRemoteAmount: Long? = null,
    @JsonProperty("repair_shield_remote_amount") val repairShieldRemoteAmount: Long? = null,
    @JsonProperty("repair_shield_self_amount") val repairShieldSelfAmount: Long? = null,
    @JsonProperty("self_destructs") val selfDestructs: Long? = null,
    @JsonProperty("warp_scramble_pc") val warpScramblePc: Long? = null,
    @JsonProperty("warp_scrambledby_npc") val warpScrambledByNpc: Long? = null,
    @JsonProperty("warp_scrambledby_pc") val warpScrambledByPc: Long? = null,
    @JsonProperty("weapon_flag_set") val weaponFlagSet: Long? = null,
    @JsonProperty("webifiedby_npc") val webifiedByNpc: Long? = null,
    @JsonProperty("webifiedby_pc") val webifiedByNPc: Long? = null,
    @JsonProperty("webifying_pc") val webifiedPc: Long? = null
)