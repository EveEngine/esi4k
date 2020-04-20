package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.ESIResponse
import net.legio.esi4k.Version
import net.legio.esi4k.model.*

class FactionWarfareResources(esiClient: ESIClient, version: Version, datasource: Datasource): ESIResources(esiClient, version, datasource) {

    fun characterFactionWarfareStatsRaw(characterId: Int) : ESIResponse {
        return callExecute("/characters/$characterId/fw/stats", authorization = true)
    }

    fun characterFactionWarfareStats(characterId: Int): ReifyResult<CharacterFactionWarfareStats> {
        return characterFactionWarfareStats(characterFactionWarfareStatsRaw(characterId))
    }

    fun characterFactionWarfareStats(esiResponse: ESIResponse): ReifyResult<CharacterFactionWarfareStats> {
        return responseToEntity(esiResponse)
    }

    fun corporationFactionWarfareStatsRaw(corporationId: Int) : ESIResponse {
        return callExecute("/corporations/$corporationId/fw/stats", authorization = true)
    }

    fun corporationFactionWarfareStats(corporationId: Int): ReifyResult<CharacterFactionWarfareStats> {
        return corporationFactionWarfareStats(corporationFactionWarfareStatsRaw(corporationId))
    }

    fun corporationFactionWarfareStats(esiResponse: ESIResponse): ReifyResult<CharacterFactionWarfareStats> {
        return responseToEntity(esiResponse)
    }

    fun factionWarfareLeaderboardsRaw(): ESIResponse {
        return callExecute("/fw/leaderboards")
    }

    fun factionWarfareLeaderboards(): ReifyResult<Leaderboard> {
        return factionWarfareLeaderboards(factionWarfareLeaderboardsRaw())
    }

    fun factionWarfareLeaderboards(esiResponse: ESIResponse): ReifyResult<Leaderboard> {
        return responseToEntity(esiResponse)
    }

    fun factionWarfareCharactersLeaderboardsRaw(): ESIResponse {
        return callExecute("/fw/leaderboards/characters")
    }

    fun factionWarfareCharactersLeaderboards(): ReifyResult<CharacterLeaderboard> {
        return factionWarfareCharactersLeaderboards(factionWarfareCharactersLeaderboardsRaw())
    }

    fun factionWarfareCharactersLeaderboards(esiResponse: ESIResponse): ReifyResult<CharacterLeaderboard> {
        return responseToEntity(esiResponse)
    }

    fun factionWarfareCorporationsLeaderboardsRaw(): ESIResponse {
        return callExecute("/fw/leaderboards/characters")
    }

    fun factionWarfareCorporationsLeaderboards(): ReifyResult<CorporationLeaderboard> {
        return factionWarfareCorporationsLeaderboards(factionWarfareCorporationsLeaderboardsRaw())
    }

    fun factionWarfareCorporationsLeaderboards(esiResponse: ESIResponse): ReifyResult<CorporationLeaderboard> {
        return responseToEntity(esiResponse)
    }

    fun factionWarfareStatsRaw(): ESIResponse {
        return callExecute("/fw/stats")
    }

    fun factionWarfareStats(): ReifyResult<List<FactionWarfareStat>> {
        return factionWarfareStats(factionWarfareStatsRaw())
    }

    fun factionWarfareStats(esiResponse: ESIResponse): ReifyResult<List<FactionWarfareStat>> {
        return responseToEntityList(esiResponse)
    }

    fun factionWarfareSystemsRaw(): ESIResponse {
        return callExecute("/fw/systems")
    }

    fun factionWarfareSystems(): ReifyResult<List<FactionWarfareSystem>> {
        return factionWarfareSystems(factionWarfareSystemsRaw())
    }

    fun factionWarfareSystems(esiResponse: ESIResponse): ReifyResult<List<FactionWarfareSystem>> {
        return responseToEntityList(esiResponse)
    }

    fun factionWarfareWarsRaw(): ESIResponse {
        return callExecute("/fw/wars")
    }

    fun factionWarfareWars(): ReifyResult<List<FactionWarfareWar>> {
        return factionWarfareWars(factionWarfareWarsRaw())
    }

    fun factionWarfareWars(esiResponse: ESIResponse): ReifyResult<List<FactionWarfareWar>> {
        return responseToEntityList(esiResponse)
    }
 }
