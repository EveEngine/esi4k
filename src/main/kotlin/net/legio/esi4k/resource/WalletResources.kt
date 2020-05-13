package net.legio.esi4k.resource

import net.legio.esi4k.*
import net.legio.esi4k.model.JournalEntry
import net.legio.esi4k.model.CharacterWalletTransaction
import net.legio.esi4k.model.CorporationWallet
import net.legio.esi4k.model.CorporationWalletTransaction

class WalletResources(client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterWalletRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/waller", authorization = true)
    }

    fun characterWallet(characterId: Int): Double? {
        return characterWallet(characterWalletRaw(characterId))
    }

    fun characterWallet(esiResponse: ESIResponse): Double? {
        return when(esiResponse){
            is ESISuccessResponse -> esiResponse.content.toDoubleOrNull()
            else -> null
        }
    }

    fun characterWalletJournalRaw(characterId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/characters/$characterId/wallet/journal", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun characterWalletJournal(characterId: Int, page: Int = 1): ReifyResult<List<JournalEntry>> {
        return characterWalletJournal(characterWalletJournalRaw(characterId, page))
    }

    fun characterWalletJournal(esiResponse: ESIResponse): ReifyResult<List<JournalEntry>> {
        return responseToEntityList(esiResponse)
    }

    fun characterWalletTransactionsRaw(characterId: Int, from: Long? = null ): ESIResponse {
        return with(createRequest("/characters/$characterId/wallet/transactions", authorization = true)){
            from?.let{addQueryParam("from_id", from.toString())}
            execute()
        }
    }

    fun characterWalletTransactions(characterId: Int, from: Long? = null): ReifyResult<List<CharacterWalletTransaction>> {
        return characterWalletTransactions(characterWalletTransactionsRaw(characterId, from))
    }

    fun characterWalletTransactions(esiResponse: ESIResponse): ReifyResult<List<CharacterWalletTransaction>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationWalletRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/wallets", authorization = true)
    }

    fun corporationWallet(corporationId: Int): ReifyResult<List<CorporationWallet>> {
        return corporationWallet(corporationWalletRaw(corporationId))
    }

    fun corporationWallet(esiResponse: ESIResponse): ReifyResult<List<CorporationWallet>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationWalletDivisionJournalsRaw(corporationId: Int, division: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/wallets/$division/journal", authorization = true)) {
            this.page = page
            execute()
        }
    }

    fun corporationWalletDivisionJournals(corporationId: Int, division: Int, page: Int = 1): ReifyResult<List<JournalEntry>> {
        return corporationWalletDivisionJournals(corporationWalletDivisionJournalsRaw(corporationId, division, page))
    }

    fun corporationWalletDivisionJournals(esiResponse: ESIResponse): ReifyResult<List<JournalEntry>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationWalletDivisionTransactionsRaw(corporationId: Int, division: Int, fromId: Long? = null): ESIResponse {
        return with(createRequest("/corporations/$corporationId/wallet/$division/transactions", authorization = true)) {
            fromId?.let{addQueryParam("from_id", fromId.toString())}
            execute()
        }
    }

    fun corporationWalletDivisionTransactions(corporationId: Int, division: Int, fromId: Long? = null): ReifyResult<List<CorporationWalletTransaction>> {
        return  corporationWalletDivisionTransactions( corporationWalletDivisionTransactionsRaw(corporationId, division, fromId))
    }

    fun corporationWalletDivisionTransactions(esiResponse: ESIResponse): ReifyResult<List<CorporationWalletTransaction>> {
        return responseToEntityList(esiResponse)
    }

}