package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.KillmailIdHash
import net.legio.esi4k.model.WarDetails
import kotlin.math.max

class WarsResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun warsRaw(maxWarId: Int? = null): ESIResponse {
        return with(createRequest("/wars")){
            maxWarId?.let {addQueryParam("max_war_id", maxWarId.toString())}
            execute()
        }
    }

    fun wars(maxWarId: Int? = null): ReifyResult<List<Int>> {
        return wars(warsRaw(maxWarId))
    }

    fun wars(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun warRaw(warId: Int): ESIResponse {
        return callExecute("/wars/$warId")
    }

    fun war(warId: Int): ReifyResult<WarDetails> {
        return war(warRaw(warId))
    }

    fun war(esiResponse: ESIResponse): ReifyResult<WarDetails> {
        return responseToEntity(esiResponse)
    }

    fun warKillmailsRaw(warId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/wars/$warId/killmails")){
            this.page = page
            execute()
        }
    }

    fun warKillmails(warId: Int, page: Int = 1): ReifyResult<List<KillmailIdHash>> {
        return warKillmails(warKillmailsRaw(warId, page))
    }

    fun warKillmails(esiResponse: ESIResponse): ReifyResult<List<KillmailIdHash>> {
        return responseToEntityList(esiResponse)
    }
}