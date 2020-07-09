package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.Datasource
import com.eve.engine.esi4k.ESIClient
import com.eve.engine.esi4k.ESIResponse
import com.eve.engine.esi4k.Version
import com.eve.engine.esi4k.model.*

class IndustryResources(esiClient: ESIClient,  datasource: Datasource): ESIResources(esiClient,  datasource) {

    fun characterIndustryJobsRaw(characterId: Int, includeCompleted: Boolean = true): ESIResponse {
        return with(createRequest("/characters/$characterId/industry/jobs", authorization = true)) {
            addQueryParam("include_completed", includeCompleted.toString())
            execute()
        }
    }

    fun characterIndustryJobs(characterId: Int, includeCompleted: Boolean = true): ReifyResult<List<IndustryJob>> {
        return characterIndustryJobs(characterIndustryJobsRaw(characterId, includeCompleted))
    }

    fun characterIndustryJobs(esiResponse: ESIResponse): ReifyResult<List<IndustryJob>> {
        return responseToEntityList(esiResponse)
    }

    fun characterMiningLedgerEntriesRaw(characterId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/character/$characterId/mining", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun characterMiningLedgerEntries(characterId: Int, page: Int = 1): ReifyResult<List<MiningLedgerEntry>> {
        return characterMiningLedgerEntries(characterMiningLedgerEntriesRaw(characterId, page))
    }

    fun characterMiningLedgerEntries(esiResponse: ESIResponse): ReifyResult<List<MiningLedgerEntry>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationMiningExtractionsRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/mining/extractions", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationMiningExtractions(corporationId: Int, page: Int = 1): ReifyResult<List<ChunkTimer>> {
        return corporationMiningExtractions(corporationMiningExtractionsRaw(corporationId, page))
    }

    fun corporationMiningExtractions(esiResponse: ESIResponse): ReifyResult<List<ChunkTimer>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationMiningObserversRaw(corporationId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporations/$corporationId/mining/observers", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationMiningObservers(corporationId: Int, page: Int = 1): ReifyResult<List<MiningObserver>> {
        return corporationMiningObservers(corporationMiningObserversRaw(corporationId, page))
    }

    fun corporationMiningObservers(esiResponse: ESIResponse): ReifyResult<List<MiningObserver>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationObserverRaw(corporationId: Int, observerId: Int, page: Int = 1): ESIResponse {
        return with(createRequest("/corporation/$corporationId/mining/observers/$observerId", authorization = true)){
            this.page = page
            execute()
        }
    }

    fun corporationObserver(corporationId: Int, observerId: Int, page: Int = 1): ReifyResult<List<ObserverMiningLedger>> {
        return corporationObserver(corporationObserverRaw(corporationId, observerId, page))
    }

    fun corporationObserver(esiResponse: ESIResponse): ReifyResult<List<ObserverMiningLedger>>{
        return responseToEntityList(esiResponse)
    }

    fun corporationIndustryJobsRaw(corporationId: Int, page: Int = 1, includeCompleted: Boolean = true): ESIResponse {
        return with(createRequest("/corporations/$corporationId/industry/jobs", authorization = true)){
            this.page = page
            addQueryParam("include_completed", includeCompleted.toString())
            execute()
        }
    }

    fun corporationIndustryJobs(corporationId: Int, page: Int = 1, includeCompleted: Boolean = true): ReifyResult<List<IndustryJob>> {
        return corporationIndustryJobs(corporationIndustryJobsRaw(corporationId, page, includeCompleted))
    }

    fun corporationIndustryJobs(esiResponse: ESIResponse): ReifyResult<List<IndustryJob>> {
        return responseToEntityList(esiResponse)
    }

    fun industryFacilitiesRaw(): ESIResponse {
        return callExecute("/industry/facilities")
    }

    fun industryFacilities(): ReifyResult<List<IndustryFacilities>>{
        return industryFacilities(industryFacilitiesRaw())
    }

    fun industryFacilities(esiResponse: ESIResponse): ReifyResult<List<IndustryFacilities>>{
        return responseToEntityList(esiResponse)
    }

    fun industrySystemsRaw(): ESIResponse {
        return callExecute("/industry/systems")
    }

    fun industrySystems(): ReifyResult<List<SystemCostIndicies>> {
        return industrySystems(industrySystemsRaw())
    }

    fun industrySystems(esiResponse: ESIResponse): ReifyResult<List<SystemCostIndicies>> {
        return responseToEntityList(esiResponse)
    }


}