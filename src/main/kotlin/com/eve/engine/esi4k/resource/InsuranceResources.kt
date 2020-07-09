package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.*
import com.eve.engine.esi4k.model.InsurancePrice

class InsuranceResources (client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun insurancePricesRaw(language: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/insurance/prices")){
            addHeader(ESIHeader.ACCEPT_LANGUAGE, language.value)
            execute()
        }
    }

    fun insurancePrices(language: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<List<InsurancePrice>> {
        return insurancePrices(insurancePricesRaw(language))
    }

    fun insurancePrices(esiResponse: ESIResponse) : ReifyResult<List<InsurancePrice>> {
        return responseToEntityList(esiResponse)
    }

}