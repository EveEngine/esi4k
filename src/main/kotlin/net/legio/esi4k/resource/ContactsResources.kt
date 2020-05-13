package net.legio.esi4k.resource

import net.legio.esi4k.*
import net.legio.esi4k.model.Contact
import net.legio.esi4k.model.ContactLabel

class ContactsResources(esiClient: ESIClient,  datasource: Datasource): ESIResources(esiClient,  datasource) {

    fun allianceContactsRaw(allianceId: Int): ESIResponse {
        return callExecute("/alliances/$allianceId/contacts", authorization = true)
    }

    fun allianceContacts(allianceId: Int): ReifyResult<List<Contact>> {
        return allianceContacts(allianceContactsRaw(allianceId))
    }

    fun allianceContacts(esiResponse: ESIResponse): ReifyResult<List<Contact>> {
        return responseToEntityList(esiResponse)
    }

    fun allianceContactLabelsRaw(allianceId: Int): ESIResponse {
        return callExecute("/alliances/$allianceId/contacts/labels", authorization = true)
    }

    fun allianceContactLabels(allianceId: Int): ReifyResult<List<ContactLabel>> {
        return allianceContactLabels(allianceContactLabelsRaw(allianceId))
    }

    fun allianceContactLabels(esiResponse: ESIResponse): ReifyResult<List<ContactLabel>> {
        return responseToEntityList(esiResponse)
    }

    fun deleteCharacterContact(characterId: Int, contactIds: List<Int>): ESIResponse {
        return with(createRequest("/characters/$characterId/contacts", HttpMethod.DELETE,true)){
            addQueryParam("contact_ids", contactIds.joinToString(","))
            execute()
        }
    }

    fun characterContactsRaw(characterId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/characters/$characterId/contacts", authorization = true)){
            addQueryParam("page", page.toString())
            execute()
        }
    }

    fun characterContacts(characterId: Int, page: Int = 1): ReifyResult<List<Contact>> {
        return characterContacts(characterContactsRaw(characterId, page))
    }

    fun characterContacts(esiResponse: ESIResponse): ReifyResult<List<Contact>> {
        return responseToEntityList(esiResponse)
    }

    fun addCharacterContacts(characterId: Int, contactIds:List<Int>, standing: Double, watch: Boolean = false, labelIds: List<Int> = listOf()) : ESIResponse {
        return with(createRequest("/characters/$characterId/contacts", HttpMethod.POST, true)){
            body = mapper.writeValueAsString(contactIds)
            addQueryParam("standing", standing.toString())
            addQueryParam("watch", watch.toString())
            labelIds.isNotEmpty().isTrue {
                addQueryParam("label_ids", labelIds.joinToString(","))
            }
            execute()
        }
    }

    fun editCharacterContacts(characterId: Int, contactIds: List<Int>, standing: Double, watched: Boolean = false, labelIds: List<Int> = listOf()): ESIResponse {
        return with(createRequest("/characters/$characterId/contacts", HttpMethod.PUT, true)){
            addQueryParam("standing", standing.toString())
            addQueryParam("watched", watched.toString())
            labelIds.isNotEmpty().isTrue {
                addQueryParam("label_ids", labelIds.joinToString(","))
            }
            body = mapper.writeValueAsString(contactIds)
            execute()
        }
    }

    fun characterContactLabelsRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/contacts/labels", authorization = true)
    }

    fun characterContactLabels(characterId: Int): ReifyResult<List<ContactLabel>> {
        return characterContactLabels(characterContactLabelsRaw(characterId))
    }

    fun characterContactLabels(esiResponse: ESIResponse): ReifyResult<List<ContactLabel>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationContactsRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/contacts", authorization = true)
    }

    fun corporationContacts(corporationId: Int): ReifyResult<List<Contact>> {
        return corporationContacts(corporationContactsRaw(corporationId))
    }

    fun corporationContacts(esiResponse: ESIResponse): ReifyResult<List<Contact>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationContactLabelsRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/contacts/labels", authorization = true)
    }

    fun corporationContactLabels(corporationId: Int): ReifyResult<List<ContactLabel>> {
        return corporationContactLabels(corporationContactLabelsRaw(corporationId))
    }

    fun corporationContactLabels(esiResponse: ESIResponse): ReifyResult<List<ContactLabel>> {
        return responseToEntityList(esiResponse)
    }
}