package net.legio.esi4k.resource

import net.legio.esi4k.*
import net.legio.esi4k.model.*


class CharacterResources(esiClient: ESIClient, version: Version = Version.LATEST, datasource: Datasource = Datasource.TRANQUILITY): ESIResources(esiClient, version, datasource) {

    fun characterRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId")
    }

    fun character(characterId: Int): ReifyResult<Character> {
        return character(characterRaw(characterId))
    }

    fun character(esiResponse: ESIResponse): ReifyResult<Character> {
        return responseToEntity(esiResponse)
    }

    fun characterAgentResearchRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/agents_research", authorization = true)
    }

    fun characterAgentResearch(characterId: Int): ReifyResult<List<AgentResearch>> {
        return characterAgentResearch(characterAgentResearchRaw(characterId))
    }

    fun characterAgentResearch(esiResponse: ESIResponse) : ReifyResult<List<AgentResearch>> {
        return responseToEntityList(esiResponse)
    }

    fun characterBlueprintsRaw(characterId: Int): ESIResponse {
        return callExecute("/character/$characterId/blueprints", authorization = true)
    }

    fun characterBlueprints(characterId: Int): ReifyResult<List<Blueprint>> {
        return characterBlueprints(characterBlueprintsRaw(characterId))
    }

    fun characterBlueprints(esiResponse: ESIResponse): ReifyResult<List<Blueprint>> {
        return responseToEntityList(esiResponse)
    }

    fun characterCorporationHistoryRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/corporationhistory")
    }

    fun characterCorporationHistory(characterId: Int): ReifyResult<List<CorporationHistory>> {
        return characterCorporationHistory(characterCorporationHistoryRaw(characterId))
    }

    fun characterCorporationHistory(esiResponse: ESIResponse): ReifyResult<List<CorporationHistory>> {
        return responseToEntityList(esiResponse)
    }

    fun characterCSPARaw(characterId: Int, characterIds: List<Int>): ESIResponse {
        return with(createRequest("/characters/$characterId/cspa", authorization = true)){
            body = mapper.writeValueAsString(characterId)
            execute()
        }
    }

    fun characterCSPA(characterId: Int, characterIds: List<Int>): ReifyResult<Float> {
        return characterCSPA(characterCSPARaw(characterId, characterIds))
    }

    fun characterCSPA(esiResponse: ESIResponse): ReifyResult<Float> {
        return responseToEntity(esiResponse)
    }

    fun characterFatigueRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/fatigue", authorization = true)
    }

    fun characterFatigue(characterId: Int): ReifyResult<JumpFatigue> {
        return characterFatigue(characterFatigueRaw(characterId))
    }

    fun characterFatigue(esiResponse: ESIResponse): ReifyResult<JumpFatigue> {
        return responseToEntity(esiResponse)
    }

    fun characterMedalsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/medals", authorization = true)
    }

    fun characterMedals(characterId: Int): ReifyResult<List<Medal>> {
        return characterMedals(characterMedalsRaw(characterId))
    }

    fun characterMedals(esiResponse: ESIResponse): ReifyResult<List<Medal>> {
        return responseToEntityList(esiResponse)
    }

    fun characterNotificationsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/notifications", authorization = true)
    }

    fun characterNotifications(characterId: Int): ReifyResult<List<Notification>> {
        return characterNotifications(characterNotificationsRaw(characterId))
    }

    fun characterNotifications(esiResponse: ESIResponse): ReifyResult<List<Notification>> {
        return responseToEntityList(esiResponse)
    }

    fun characterContactNotificationsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/notifications/contacts", authorization = true)
    }

    fun characterContactNotifications(characterId: Int): ReifyResult<List<ContactNotification>> {
        return characterContactNotifications(characterContactNotificationsRaw(characterId))
    }

    fun characterContactNotifications(esiResponse: ESIResponse): ReifyResult<List<ContactNotification>> {
        return responseToEntityList(esiResponse)
    }

    fun characterPortraitsRaw(characterId: Int): ESIResponse {
        return callExecute("/character/$characterId/portrait")
    }

    fun characterPortraits(characterId: Int): ReifyResult<Portraits> {
        return characterPortraits(characterPortraitsRaw(characterId))
    }

    fun characterPortraits(esiResponse: ESIResponse): ReifyResult<Portraits> {
        return responseToEntity(esiResponse)
    }

    fun characterRolesRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/roles", authorization = true)
    }

    fun characterRoles(characterId: Int): ReifyResult<Roles> {
        return characterRoles(characterRolesRaw(characterId))
    }

    fun characterRoles(esiResponse: ESIResponse): ReifyResult<Roles> {
        return responseToEntity(esiResponse)
    }

    fun characterStandingsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/standings", authorization = true)
    }

    fun characterStandings(characterId: Int): ReifyResult<List<Standing>> {
        return characterStandings(characterStandingsRaw(characterId))
    }

    fun characterStandings(esiResponse: ESIResponse): ReifyResult<List<Standing>> {
        return responseToEntityList(esiResponse)
    }

    //TODO Do Character stats (GONNA TAKE SOME TIME)

    fun characterTitlesRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/titles", authorization = true)
    }

    fun characterTitles(characterId: Int): ReifyResult<List<CharacterTitle>> {
        return characterTitles(characterTitlesRaw(characterId))
    }

    fun characterTitles(esiResponse: ESIResponse): ReifyResult<List<CharacterTitle>> {
        return responseToEntityList(esiResponse)
    }

    fun characterAffiliationRaw(characterIds: List<Int>): ESIResponse {
        return with(createRequest("/character/affiliation", HttpMethod.POST, true)){
            body = mapper.writeValueAsString(characterIds)
            execute()
        }
    }

    fun characterAffiliation(characterIds: List<Int>): ReifyResult<List<Affiliation>> {
        return characterAffiliation(characterAffiliationRaw(characterIds))
    }

    fun characterAffiliation(esiResponse: ESIResponse): ReifyResult<List<Affiliation>> {
        return responseToEntityList(esiResponse)
    }

    

 }