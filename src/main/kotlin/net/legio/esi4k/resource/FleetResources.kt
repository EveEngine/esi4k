package net.legio.esi4k.resource

import net.legio.esi4k.*
import net.legio.esi4k.model.*
import net.legio.esi4k.model.internal.FleetInvitation
import net.legio.esi4k.model.internal.FleetMovement
import net.legio.esi4k.model.internal.NewFleetSettings
import org.apache.http.client.methods.HttpPost

class FleetResources(client: ESIClient, version: Version = Version.LATEST, datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client, version, datasource) {

    fun characterFleetRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/fleet", authorization = true)
    }

    fun characterFleet(characterId: Int): ReifyResult<CharacterFleet> {
        return characterFleet(characterFleetRaw(characterId))
    }

    fun characterFleet(esiResponse: ESIResponse): ReifyResult<CharacterFleet>{
        return responseToEntity(esiResponse)
    }

    fun fleetsRaw(fleetId: Long): ESIResponse {
        return callExecute("/fleets/$fleetId", authorization = true)
    }

    fun fleet(fleetId: Long): ReifyResult<Fleet> {
        return fleet(fleetsRaw(fleetId))
    }

    fun fleet(esiResponse: ESIResponse): ReifyResult<Fleet> {
        return responseToEntity(esiResponse)
    }

    fun updateFleet(fleetId: Long, isFreeMove: Boolean? = null, motd: String? = null): ESIResponse {
        val newSettings = NewFleetSettings(isFreeMove, motd)
        return with(createRequest("/fleets/$fleetId", HttpMethod.PUT, true)){
            body = mapper.writeValueAsString(newSettings)
            execute()
        }
    }

    fun fleetMembersRaw(fleetId: Long, language: AcceptLanguages = AcceptLanguages.EN_US): ESIResponse {
        return with(createRequest("/fleets/$fleetId/members", authorization = true)){
            addHeader(ESIHeader.ACCEPT_LANGUAGE, language.value)
            execute()
        }
    }

    fun fleetMembers(fleetId: Long, language: AcceptLanguages = AcceptLanguages.EN_US): ReifyResult<List<FleetMember>> {
        return fleetMembers(fleetMembersRaw(fleetId,language))
    }

    fun fleetMembers(esiResponse: ESIResponse): ReifyResult<List<FleetMember>> {
        return responseToEntityList(esiResponse)
    }

    fun createFleetInvitation(fleetId: Long, characterId: Int, role: FleetRole, squadId: Long? = null, wingId: Long? = null): ESIResponse{
        return with(createRequest("/fleets/$fleetId/members", HttpMethod.POST, true)){
            body = mapper.writeValueAsString(FleetInvitation(characterId, role.value, squadId, wingId))
            return execute()
        }
    }

    fun kickFleetMember(fleetId: Long, memberId: Int): ESIResponse {
        return callExecute("/fleets/$fleetId/members/$memberId", HttpMethod.DELETE, true)
    }

    fun moveFleetMember(fleetId: Long, memberId: Int, role: FleetRole, squadId: Long? = null, wingId: Long? = null): ESIResponse {
        return with(createRequest("/fleets/$fleetId/members/$memberId", HttpMethod.PUT, true)){
            body = mapper.writeValueAsString(FleetMovement(role.value, squadId, wingId))
            execute()
        }
    }

    fun deleteFleetSquad(fleetId: Long, squadId: Long): ESIResponse {
        return callExecute("/fleets/$fleetId/squads/$squadId", HttpMethod.DELETE, true)
    }

    fun renameFleetSquad(fleetId: Long, squadId: Long, name: String): ESIResponse {
        return with(createRequest("/fleets/$fleetId/squads/$squadId", HttpMethod.PUT, true)){
            body = "{'name': '$name'}}"
            execute()
        }
    }

    fun fleetWingsRaw(fleetId: Long): ESIResponse {
        return callExecute("/fleets/$fleetId/wings", authorization = true)
    }

    fun fleetWings(fleetId: Long): ReifyResult<List<FleetWing>> {
        return fleetWings(fleetWingsRaw(fleetId))
    }

    fun fleetWings(esiResponse: ESIResponse): ReifyResult<List<FleetWing>> {
        return responseToEntityList(esiResponse)
    }

    fun createFleetWingRaw(fleetId: Long): ESIResponse {
        return callExecute("/fleets/$fleetId/wings", HttpMethod.POST, true)
    }

    fun createFleetWing(fleetId: Long): ReifyResult<WingCreated> {
        return createFleetWing(createFleetWingRaw(fleetId))
    }

    fun createFleetWing(esiResponse: ESIResponse): ReifyResult<WingCreated> {
        return responseToEntity(esiResponse)
    }

    fun deleteFleetWing(fleetId: Long, wingId: Long): ESIResponse {
        return callExecute("/fleets/$fleetId/wings/$wingId", HttpMethod.DELETE, true)
    }

    fun renameFleetWing(fleetId: Long, wingId: Long, name: String): ESIResponse {
        return with(createRequest("/fleets/$fleetId/wings/$wingId", HttpMethod.PUT, true)) {
            body = "{'name': '$name'}"
            execute()
        }
    }

    fun createFleetSquadRaw(fleetId: Long, wingId: Long): ESIResponse {
        return callExecute("/fleets/$fleetId/wings/$wingId/squads", HttpMethod.POST, true)
    }

    fun createFleetSquad(fleetId: Long, wingId: Long): ReifyResult<SquadCreated> {
        return createFleetSquad(createFleetSquadRaw(fleetId, wingId))
    }

    fun createFleetSquad(esiResponse: ESIResponse): ReifyResult<SquadCreated> {
        return responseToEntity(esiResponse)
    }

}
