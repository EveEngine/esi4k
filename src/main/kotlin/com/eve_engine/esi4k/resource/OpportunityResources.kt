package com.eve_engine.esi4k.resource

import com.eve_engine.esi4k.*
import com.eve_engine.esi4k.model.OpportunityGroup
import com.eve_engine.esi4k.model.OpportunityTask
import com.eve_engine.esi4k.model.OpportunityTaskId

class OpportunityResources(client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun characterOpportunitiesRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/opportunities", authorization = true)
    }

    fun characterOpportunities(characterId: Int): ReifyResult<List<OpportunityTaskId>> {
        return  characterOpportunities(characterOpportunitiesRaw(characterId))
    }

    fun characterOpportunities(esiResponse: ESIResponse): ReifyResult<List<OpportunityTaskId>> {
        return responseToEntityList(esiResponse)
    }

    fun opportunityGroupsRaw(): ESIResponse {
        return callExecute("/opportunities/groups")
    }

    fun opportunityGroups(): ReifyResult<List<Int>> {
        return opportunityGroups(opportunityGroupsRaw())
    }

    fun opportunityGroups(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun opportunityGroupRaw(groupId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/opportunities/groups/$groupId")){
            addHeader(ESIHeader.ACCEPT_LANGUAGE, acceptLanguages.value)
            execute()
        }
    }

    fun opportunityGroups(groupId: Int, acceptLanguages: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<List<OpportunityGroup>> {
        return opportunityGroup(opportunityGroupRaw(groupId, acceptLanguages))
    }

    fun opportunityGroup(esiResponse: ESIResponse): ReifyResult<List<OpportunityGroup>> {
        return responseToEntityList(esiResponse)
    }

    fun opportunityTasksRaw(): ESIResponse {
        return callExecute("/opportunities/tasks")
    }

    fun opportunityTasks(): ReifyResult<List<Int>> {
        return opportunityTasks(opportunityTasksRaw())
    }

    fun opportunityTasks(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun opportunityTaskRaw(taskId: Int): ESIResponse {
        return callExecute("/opportunities/task/$taskId")
    }

    fun opportunityTask(taskId: Int): ReifyResult<List<OpportunityTask>> {
        return opportunityTask(opportunityTaskRaw(taskId))
    }

    fun opportunityTask(esiResponse: ESIResponse): ReifyResult<List<OpportunityTask>> {
        return responseToEntityList(esiResponse)
    }

}