package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.Killmail
import net.legio.esi4k.model.KillmailIdHash

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