package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Roles (
    @JsonProperty("roles") val roles: List<CharacterRoles>? = null,
    @JsonProperty("roles_at_base") val rolesAtBase: List<CharacterRoles>? = null,
    @JsonProperty("roles_at_hq") val rolesAtHq: List<CharacterRoles>? = null,
    @JsonProperty("roles_at_other") val rolesAtOther: List<CharacterRoles>? = null
)

enum class CharacterRoles {
    AccountTake1, AccountTake2, AccountTake3, AccountTake4, AccountTake5, AccountTake6, AccountTake7, Accountant, Auditor, CommunicationsOfficer, ConfigEquipment, ConfigStarbaseEquipment, ContainerTake1, ContainerTake2, ContainerTake3, ContainerTake4, ContainerTake5, ContainerTake6, ContainerTake7, ContractManager, Diplomat, Director, FactoryManager, FittingManager, HangarQuery1, HangarQuery2, HangarQuery3, HangarQuery4, HangarQuery5, HangarQuery6, HangarQuery7, HangarTake1, HangarTake2, HangarTake3, HangarTake4, HangarTake5, HangarTake6, HangarTake7, JuniorAccountant, PersonnelManager, RentFactoryFacility, RentOffice, RentResearchFacility, SecurityOfficer, StarbaseDefenseOperator, StarbaseFuelTechnician, StationManager, Trader
}

enum class RoleType {
    GrantableRoles, GrantableRolesAtBase, GrantableRolesAtHq, GrantableRolesAtOther, Roles, RolesAtBase, RolesAtHq, RolesAtOther
}