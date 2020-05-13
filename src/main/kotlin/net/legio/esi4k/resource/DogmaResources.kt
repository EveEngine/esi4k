package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.DogmaAttribute
import net.legio.esi4k.model.DogmaDynamicItem
import net.legio.esi4k.model.DogmaEffect

class DogmaResources(esiClient: ESIClient,  datasource: Datasource): ESIResources(esiClient,  datasource) {

    fun dogmaAttributesIdsRaw(): ESIResponse {
        return callExecute("/dogma/attributes")
    }

    fun dogmaAttributesIds(): ReifyResult<List<Int>> {
        return dogmaAttributesIds(dogmaAttributesIdsRaw())
    }

    fun dogmaAttributesIds(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun dogmaAttributeRaw(attributeId: Int): ESIResponse {
        return callExecute("/dogma/attributes/$attributeId")
    }

    fun dogmaAttribute(attributeId: Int): ReifyResult<DogmaAttribute> {
        return dogmaAttribute(dogmaAttributeRaw(attributeId))
    }

    fun dogmaAttribute(esiResponse: ESIResponse): ReifyResult<DogmaAttribute> {
        return responseToEntity(esiResponse)
    }

    fun dogmaDynamicItemsRaw(typeId: Int, itemId: Long): ESIResponse {
        return callExecute("/dogma/dynamics/items/$typeId/$itemId")
    }

    fun dogmaDynamicItems(typeId: Int, itemId: Long): ReifyResult<DogmaDynamicItem> {
        return dogmaDynamicItems(dogmaDynamicItemsRaw(typeId, itemId))
    }

    fun dogmaDynamicItems(esiResponse: ESIResponse): ReifyResult<DogmaDynamicItem> {
        return responseToEntity(esiResponse)
    }

    fun dogmaEffectsRaw(): ESIResponse {
        return callExecute("/dogma/effects")
    }

    fun dogmaEffects(): ReifyResult<List<Int>> {
        return dogmaEffects(dogmaEffectsRaw())
    }

    fun dogmaEffects(esiResponse: ESIResponse): ReifyResult<List<Int>> {
        return responseToEntityList(esiResponse)
    }

    fun dogmaEffectRaw(effectId: Int): ESIResponse {
        return callExecute("/dogma/effects/$effectId")
    }

    fun dogmaEffect(effectId: Int): ReifyResult<DogmaEffect> {
        return dogmaEffect(dogmaEffectRaw(effectId))
    }

    fun dogmaEffect(esiResponse: ESIResponse): ReifyResult<DogmaEffect> {
        return responseToEntity(esiResponse)
    }
}