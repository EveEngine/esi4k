package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.Datasource
import com.eve.engine.esi4k.ESIClient
import com.eve.engine.esi4k.ESIResponse
import com.eve.engine.esi4k.Version
import com.eve.engine.esi4k.model.Killmail
import com.eve.engine.esi4k.model.KillmailIdHash

class KillmailResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterRecentKillmailsRaw(characterId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/characters/$characterId/killmails/recent", authorization = true)) {
            this.page = page
            execute()
        }
    }

    fun characterRecentKillmails(characterId: Int, page: Int = 1): ReifyResult<List<KillmailIdHash>> {
        return characterRecentKillmails(characterRecentKillmailsRaw(characterId, page))
    }

    fun characterRecentKillmails(esiResponse: ESIResponse): ReifyResult<List<KillmailIdHash>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationRecentKillmailsRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/killmails/recent", authorization = true)) {
            this.page = page
            execute()
        }
    }

    fun corporationRecentKillmails(corporationId: Int, page: Int = 1): ReifyResult<List<KillmailIdHash>> {
        return corporationRecentKillmails(corporationRecentKillmailsRaw(corporationId, page))
    }

    fun corporationRecentKillmails(esiResponse: ESIResponse): ReifyResult<List<KillmailIdHash>> {
        return responseToEntityList(esiResponse)
    }

    fun killmailRaw(killmailId: Int, killmailHash: String): ESIResponse {
        return callExecute("/killmails/$killmailId/$killmailHash")
    }

    fun killmail(killmailId: Int, killmailHash: String): ReifyResult<Killmail> {
        return killmail(killmailRaw(killmailId, killmailHash))
    }

    fun killmail(esiResponse: ESIResponse): ReifyResult<Killmail> {
        return responseToEntity(esiResponse)
    }
}