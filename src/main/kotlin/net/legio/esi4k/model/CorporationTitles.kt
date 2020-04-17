package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.management.relation.Role

data class CorporationTitles (
    @JsonProperty("grantable_roles") val grantableRoles: List<CharacterRoles>? = null,
    @JsonProperty("grantable_roles_at_base") val grantableRolesAtBase: List<CharacterRoles>? = null,
    @JsonProperty("grantable_roles_at_hq") val grantableRolesAtHq: List<CharacterRoles>? = null,
    @JsonProperty("grantable_roles_at_other") val grantableRolesAtOther: List<CharacterRoles>? = null,
    @JsonProperty("name") val name: String? = null,
    @JsonProperty("roles") val roles: List<CharacterRoles>? = null,
    @JsonProperty("roles_at_base") val rolesAtBase: List<CharacterRoles>? = null,
    @JsonProperty("roles_at_hq") val rolesAtHq: List<CharacterRoles>? = null,
    @JsonProperty("roles_at_other") val rolesAtOther: List<CharacterRoles>? = null,
    @JsonProperty("title_id") val titleId: Int? = null
)