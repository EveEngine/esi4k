package net.legio.esi4k.resource

import net.legio.esi4k.*
import net.legio.esi4k.model.*
import net.legio.esi4k.model.internal.NewMailLabel

class MailResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterMailHeadersRaw(characterId: Int, labels: List<Int>? = null, lastMailId: Int? = null): ESIResponse {
        return with(createRequest("/characters/$characterId/mail", authorization = true)) {
            labels?.let {addQueryParam("labels", labels.joinToString(",")) }
            lastMailId?.let { addQueryParam("last_mail_id", lastMailId.toString()) }
            execute()
        }
    }

    fun characterMailHeaders(characterId: Int, labels: List<Int>? = null, lastMailId: Int? = null): ReifyResult<List<MailHeader>> {
        return characterMailHeaders(characterMailHeadersRaw(characterId, labels, lastMailId))
    }

    fun characterMailHeaders(esiResponse: ESIResponse): ReifyResult<List<MailHeader>> {
        return responseToEntityList(esiResponse)
    }

    fun sendNewMailRaw(characterId: Int, newMail: NewMail): ESIResponse {
        return with(createRequest("/characters/$characterId/mail", HttpMethod.POST, true)) {
            body = mapper.writeValueAsString(newMail)
            execute()
        }
    }

    fun sendNewMail(characterId: Int, newMail: NewMail): ReifyResult<Int> {
        return sendNewMail(sendNewMailRaw(characterId, newMail))
    }

    fun sendNewMail(esiResponse: ESIResponse): ReifyResult<Int>{
        return responseToEntity(esiResponse)
    }

    fun deleteMail(characterId: Int, mailId: Int): ESIResponse {
        return callExecute("/characters/$characterId/mail/$mailId", HttpMethod.DELETE, true)
    }

    fun characterMailRaw(characterId: Int, mailId: Int): ESIResponse {
        return callExecute("/characters/$characterId/mail/$mailId", authorization = true)
    }

    fun characterMail(characterId: Int, mailId: Int): ReifyResult<Mail> {
        return characterMail(characterMailRaw(characterId, mailId))
    }

    fun characterMail(esiResponse: ESIResponse): ReifyResult<Mail> {
        return responseToEntity(esiResponse)
    }

    fun updateMailMetadata(characterId: Int, mailId: Int, mailMetadata: MailMetadata): ESIResponse {
        return with(createRequest("/characters/$characterId/mail/$mailId", HttpMethod.PUT, true)) {
            body = mapper.writeValueAsString(mailMetadata)
            execute()
        }
    }

    fun characterMailLabelsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/mail/labels", authorization = true)
    }

    fun characterMailLabels(characterId: Int): ReifyResult<MailLabels> {
        return characterMailLabels(characterMailLabelsRaw(characterId))
    }

    fun characterMailLabels(esiResponse: ESIResponse): ReifyResult<MailLabels> {
        return responseToEntity(esiResponse)
    }

    fun createMailLabelRaw(characterId: Int, name: String, color: LabelColor? = null): ESIResponse {
        return with(createRequest("/characters/$characterId/mail/labels", HttpMethod.POST, true)){
            body = mapper.writeValueAsString(NewMailLabel(color, name))
            execute()
        }
    }

    fun createMailLabel(characterId: Int, name: String, color: LabelColor? = null): ReifyResult<Int> {
        return createMailLabel(createMailLabelRaw(characterId, name, color))
    }

    fun createMailLabel(esiResponse: ESIResponse): ReifyResult<Int> {
        return responseToEntity(esiResponse)
    }

    fun deleteMailLabel(characterId: Int, labelId: Int): ESIResponse {
        return callExecute("/characters/$characterId/mail/labels/$labelId", HttpMethod.DELETE, true)
    }

    fun characterMailingListSubscriptionsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/mail/lists", authorization = true)
    }

    fun characterMailingListSubscriptions(characterId: Int): ReifyResult<List<MailingListSubscription>> {
        return characterMailingListSubscriptions(characterMailingListSubscriptionsRaw(characterId))
    }

    fun characterMailingListSubscriptions(esiResponse: ESIResponse): ReifyResult<List<MailingListSubscription>> {
        return responseToEntityList(esiResponse)
    }

}