package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Killmail (
        @JsonProperty("attackers") val attackers: List<Attacker>,
        @JsonProperty("killmail_id") val killmailId: Int,
        @JsonProperty("killmail_time") val killmailTime: String,
        @JsonProperty("moon_id") val moonId: Int? = null,
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("victim") val victim: Victim,
        @JsonProperty("war_id") val warId: Int
)

data class Attacker (
        @JsonProperty("alliance_id") val allianceId: Int? = null,
        @JsonProperty("character_id") val characterId: Int? = null,
        @JsonProperty("corporation_id") val corporationId: Int? = null,
        @JsonProperty("damage_done") val damageDone: Int,
        @JsonProperty("faction_id") val factionId: Int? = null,
        @JsonProperty("final_blow") val finalBlow: Boolean,
        @JsonProperty("security_status") val securityStatus: Float,
        @JsonProperty("ship_type_id") val shipTypeId: Int? = null,
        @JsonProperty("weapon_type_id") val weaponTypeId: Int? = null
)

data class Victim (
        @JsonProperty("alliance_id") val allianceId: Int? = null,
        @JsonProperty("character_id") val characterId: Int? = null,
        @JsonProperty("corporation_id") val corporationId: Int? = null,
        @JsonProperty("damage_taken") val damageTake: Int,
        @JsonProperty("faction_id") val factionId: Int? = null,
        @JsonProperty("items") val items: List<VictimItem>,
        @JsonProperty("position") val position: Position? = null,
        @JsonProperty("ship_type_id") val shipTypeId: Int
)

data class VictimItem (
        @JsonProperty("flag") val flag: Int,
        @JsonProperty("item_type_id") val itemTypeId: Int,
        @JsonProperty("items") val items: List<ContainerItems>? = null,
        @JsonProperty("quantity_destroyed") val quantityDestroyed: Long? = null,
        @JsonProperty("quantity_dropped") val quantityDropped: Long? = null,
        @JsonProperty("singleton") val singleton: Int
)

data class ContainerItems (
        @JsonProperty("flag") val flag: Int,
        @JsonProperty("item_type_id") val itemTypeId: Int,
        @JsonProperty("quantity_destroyed") val quantityDestroyed: Long? = null,
        @JsonProperty("quantity_dropped") val quantityDropped: Long? = null,
        @JsonProperty("singleton") val singleton: Int
)