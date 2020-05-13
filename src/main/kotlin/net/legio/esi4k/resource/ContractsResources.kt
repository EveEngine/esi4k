package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.*

class ContractsResources(esiClient: ESIClient,  datasource:Datasource): ESIResources(esiClient,  datasource) {

    fun characterContractsRaw(characterId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/characters/$characterId/contracts", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun characterContracts(characterId: Int, page: Int = 1): ReifyResult<List<Contract>> {
        return characterContracts(characterContractsRaw(characterId, page))
    }

    fun characterContracts(esiResponse: ESIResponse): ReifyResult<List<Contract>> {
        return responseToEntityList(esiResponse)
    }

    fun characterContractBidRaw(characterId: Int, contractId: Int): ESIResponse {
        return callExecute("/characters/$characterId/contracts/$contractId/bids", authorization = true)
    }

    fun characterContractBid(characterId: Int, contractId: Int): ReifyResult<List<ContractBid>> {
        return characterContractBid(characterContractBidRaw(characterId, contractId))
    }

    fun characterContractBid(esiResponse: ESIResponse): ReifyResult<List<ContractBid>> {
        return responseToEntityList(esiResponse)
    }

    fun characterContractItemsRaw(characterId: Int, contractId: Int): ESIResponse {
        return callExecute("/characters/$characterId/contracts/$contractId/items", authorization = true)
    }

    fun characterContractItems(characterId: Int, contractId: Int): ReifyResult<List<ContractItem>> {
        return characterContractItems(characterContractItemsRaw(characterId, contractId))
    }

    fun characterContractItems(esiResponse: ESIResponse): ReifyResult<List<ContractItem>> {
        return responseToEntityList(esiResponse)
    }

    fun publicContractsRaw(regionId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/contracts/public/$regionId")){
            this.page = page
            execute()
        }
    }

    fun publicContracts(regionId: Int, page: Int = 1): ReifyResult<List<PublicContract>> {
        return publicContracts(publicContractsRaw(regionId, page))
    }

    fun publicContracts(esiResponse: ESIResponse): ReifyResult<List<PublicContract>> {
        return responseToEntityList(esiResponse)
    }

    fun publicContractBidsRaw(contractId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/contracts/public/bids/$contractId")){
            this.page = page
            execute()
        }
    }

    fun publicContractBids(contractId: Int, page: Int = 1): ReifyResult<List<PublicContractBid>> {
        return publicContractBids(publicContractBidsRaw(contractId, page))
    }

    fun publicContractBids(esiResponse: ESIResponse): ReifyResult<List<PublicContractBid>> {
        return responseToEntityList(esiResponse)
    }

    fun publicContractItemsRaw(contractId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/contracts/public/items/$contractId")) {
            this.page = page
            execute()
        }
    }

    fun publicContractItems(contractId: Int, page: Int =1 ): ReifyResult<List<PublicContractItem>> {
        return publicContractItems(publicContractItemsRaw(contractId, page))
    }

    fun publicContractItems(esiResponse: ESIResponse): ReifyResult<List<PublicContractItem>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationContractsRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/contracts", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationContracts(corporationId: Int, page: Int = 1): ReifyResult<List<Contract>> {
        return corporationContracts(corporationContractsRaw(corporationId, page))
    }

    fun corporationContracts(esiResponse: ESIResponse): ReifyResult<List<Contract>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationContractBidRaw(corporationId: Int, contractId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/contracts/$contractId/bids", authorization = true)
    }

    fun corporationContractBid(corporationId: Int, contractId: Int): ReifyResult<List<ContractBid>> {
        return corporationContractBid(corporationContractBidRaw(corporationId, contractId))
    }

    fun corporationContractBid(esiResponse: ESIResponse): ReifyResult<List<ContractBid>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationContractItemsRaw(corporationId: Int, contractId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/contracts/$contractId/items", authorization = true)
    }

    fun corporationContractItems(corporationId: Int, contractId: Int): ReifyResult<List<ContractItem>> {
        return corporationContractItems(corporationContractItemsRaw(corporationId, contractId))
    }

    fun corporationContractItems(esiResponse: ESIResponse): ReifyResult<List<ContractItem>> {
        return responseToEntityList(esiResponse)
    }

}