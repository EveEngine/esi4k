package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.management.monitor.StringMonitor

data class RoleChange (
    @JsonProperty("changed_at") val changedAt: String,
    @JsonProperty("character_id") val characterId: Int,
    @JsonProperty("issuer_id") val issuerId: Int,
    @JsonProperty("new_roles") val newRoles: List<CharacterRoles>,
    @JsonProperty("old_roles") val oldRoles: List<CharacterRoles>,
    @JsonProperty("role_type") val roleType: RoleType
)