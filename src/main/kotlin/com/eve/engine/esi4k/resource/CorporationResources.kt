package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.*
import com.eve.engine.esi4k.model.*

class CorporationResources(esiClient: ESIClient,  datasource: Datasource): ESIResources(esiClient,  datasource) {

    fun corporationRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId")
    }

    fun corporation(corporationId: Int): ReifyResult<Corporation> {
        return corporation(corporationRaw(corporationId))
    }

    fun corporation(esiResponse: ESIResponse): ReifyResult<Corporation> {
        return responseToEntity(esiResponse)
    }

    fun corporationAllianceHistoryRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/alliancehistory")
    }

    fun corporationAllianceHistory(corporationId: Int): ReifyResult<List<AllianceHistory>> {
        return corporationAllianceHistory(corporationAllianceHistoryRaw(corporationId))
    }

    fun corporationAllianceHistory(esiResponse: ESIResponse): ReifyResult<List<AllianceHistory>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationBlueprintsRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/blueprints", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationBlueprints(corporationId: Int, page: Int = 1): ReifyResult<List<Blueprint>> {
        return corporationBlueprints(corporationBlueprintsRaw(corporationId, page))
    }

    fun corporationBlueprints(esiResponse: ESIResponse): ReifyResult<List<Blueprint>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationContainerLogsRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/containers/logs", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationContainerLogs(corporationId: Int, page: Int = 1): ReifyResult<List<ALSCLog>> {
        return corporationContainerLogs(corporationContainerLogsRaw(corporationId, page))
    }

    fun corporationContainerLogs(esiResponse: ESIResponse): ReifyResult<List<ALSCLog>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationDivisionsRaw(corporationId: Int) : ESIResponse {
        return callExecute("/corporations/$corporationId/divisions", authorization = true)
    }

    fun corporationDivisions(corporationId: Int): ReifyResult<List<Division>>{
        return corporationDivision(corporationDivisionsRaw(corporationId))
    }

    fun corporationDivision(esiResponse: ESIResponse): ReifyResult<List<Division>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationFacilitiesRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/facilities", authorization = true)
    }

    fun corporationFacilities(corporationId: Int): ReifyResult<List<Facility>> {
        return corporationFacilities(corporationFacilitiesRaw(corporationId))
    }

    fun corporationFacilities(esiResponse: ESIResponse): ReifyResult<List<Facility>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationIconsRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/icons")
    }

    fun corporationIcons(corporationId: Int): ReifyResult<Icons> {
        return corporationIcons(corporationIconsRaw(corporationId))
    }

    fun corporationIcons(esiResponse: ESIResponse): ReifyResult<Icons> {
        return responseToEntity(esiResponse)
    }

    fun corporationMedalsRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/medals", authorization = true)){
            this.page= page
            execute()
        }
    }

    fun corporationMedals(corporationId: Int, page: Int = 1): ReifyResult<List<CorporationMedal>> {
        return corporationMedals(corporationMedalsRaw(corporationId, page))
    }

    fun corporationMedals(esiResponse: ESIResponse): ReifyResult<List<CorporationMedal>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationMedalsIssuedRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/medals/issued", authorization = true)){
            this.page= page
            execute()
        }
    }

    fun corporationMedalsIssued(corporationId: Int, page: Int = 1): ReifyResult<List<IssuedMedal>> {
        return corporationMedalsIssued(corporationMedalsIssuedRaw(corporationId, page))
    }

    fun corporationMedalsIssued(esiResponse: ESIResponse): ReifyResult<List<IssuedMedal>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationMembersRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/members", authorization = true)
    }

    fun corporationMembers(corporationId: Int): ReifyResult<List<Int>> {
        return corporationMembers(corporationMembersRaw(corporationId))
    }

    fun corporationMembers(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationMembersLimitRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporation/$corporationId/members/limit", authorization = true)
    }

    fun corporationMembersLimit(corporationId: Int): ReifyResult<Int> {
        return corporationMembersLimit(corporationMembersLimitRaw(corporationId))
    }

    fun corporationMembersLimit(esiResponse: ESIResponse): ReifyResult<Int> {
        return responseToEntity(esiResponse)
    }

    fun corporationMembersTitlesRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporation/$corporationId/members/titles", authorization = true)
    }

    fun corporationMembersTitles(corporationId: Int): ReifyResult<List<CharacterTitles>> {
        return corporationMembersTitles(corporationMembersTitlesRaw(corporationId))
    }

    fun corporationMembersTitles(esiResponse: ESIResponse): ReifyResult<List<CharacterTitles>> {
        return responseToEntityList(esiResponse)
    }

    fun  corporationMembersTrackingRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/membertracking", authorization = true)
    }

    fun corporationMembersTracking(corporationId: Int): ReifyResult<List<MemberTracking>> {
        return corporationMembersTracking(corporationMembersTrackingRaw(corporationId))
    }

    fun corporationMembersTracking(esiResponse: ESIResponse): ReifyResult<List<MemberTracking>>{
        return responseToEntityList(esiResponse)
    }

    fun corporationRolesRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporation/$corporationId/roles", authorization = true)
    }

    fun corporationRoles(corporationId: Int): ReifyResult<List<Roles>> {
        return corporationRoles(corporationRolesRaw(corporationId))
    }

    fun corporationRoles(esiResponse: ESIResponse): ReifyResult<List<Roles>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationRolesHistoryRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporation/$corporationId/roles", authorization = true)
    }

    fun corporationRolesHistory(corporationId: Int): ReifyResult<List<RoleChange>> {
        return corporationRolesHistory(corporationRolesHistoryRaw(corporationId))
    }

    fun corporationRolesHistory(esiResponse: ESIResponse): ReifyResult<List<RoleChange>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationShareholdersRaw(corporationId: Int, page: Int = 1 ): ESIResponse {
        return with(createRequest("/corporation/$corporationId/shareholders", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationShareholders(corporationId: Int, page: Int = 1): ReifyResult<List<Shareholder>> {
        return corporationShareholders(corporationShareholdersRaw(corporationId, page))
    }

    fun corporationShareholders(esiResponse: ESIResponse): ReifyResult<List<Shareholder>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationStandingsRaw(corporationId: Int, page: Int = 1 ): ESIResponse {
        return with(createRequest("/corporation/$corporationId/standings", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationStandings(corporationId: Int, page: Int = 1): ReifyResult<List<Standing>> {
        return corporationStandings(corporationStandingsRaw(corporationId, page))
    }

    fun corporationStandings(esiResponse: ESIResponse): ReifyResult<List<Standing>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationStarbasesRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporation/$corporationId/starbases", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationStarbases(corporationId: Int, page: Int = 1): ReifyResult<List<CorporationStarbase>> {
        return corporationStarbases(corporationStarbasesRaw(corporationId, page))
    }

    fun corporationStarbases(esiResponse: ESIResponse): ReifyResult<List<CorporationStarbase>>{
        return responseToEntityList(esiResponse)
    }

    fun corporationStarbaseRaw(corporationId: Int, starbaseId: Long, systemId: Int): ESIResponse {
        return with(createRequest("/corporations/$corporationId/starbases/$starbaseId", authorization = true)){
            addQueryParam("system_id", systemId.toString())
            execute()
        }
    }

    fun corporationStarbase(corporationId: Int, starbaseId: Long, systemId: Int): ReifyResult<Starbase> {
        return corporationStarbase(corporationStarbaseRaw(corporationId, starbaseId, systemId))
    }

    fun corporationStarbase(esiResponse: ESIResponse): ReifyResult<Starbase> {
        return responseToEntity(esiResponse)
    }

    fun corporationStructuresRaw(corporationId: Int, page: Int = 1, acceptLanguage: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/corporations/$corporationId/structures", authorization = true)){
            this.page = page
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguage.value)
            execute()
        }
    }

    fun corporationStructures(corporationId: Int, page: Int = 1, acceptLanguage: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<List<CorporationStructure>> {
        return corporationStructures(corporationStructuresRaw(corporationId, page, acceptLanguage))
    }

    fun corporationStructures(esiResponse: ESIResponse): ReifyResult<List<CorporationStructure>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationTitlesRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporation/$corporationId/titles", authorization = true)
    }

    fun corporationTitles(corporationId: Int): ReifyResult<List<CorporationTitles>>{
        return corporationTitles(corporationTitlesRaw(corporationId))
    }

    fun corporationTitles(esiResponse: ESIResponse): ReifyResult<List<CorporationTitles>> {
        return responseToEntityList(esiResponse)
    }

    fun npcCorporationsRaw(): ESIResponse {
        return callExecute("/corporations/npccorps")
    }

    fun npcCorporations(): ReifyResult<List<Int>> {
        return npcCorporations(npcCorporationsRaw())
    }

    fun npcCorporations(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }
}