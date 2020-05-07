package net.legio.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class SovereigntyCampaign (
        @JsonProperty("attackers_score") val attackersScore: Float? = null,
        @JsonProperty("campaign_id") val campaignId: Int,
        @JsonProperty("constellation_id") val constellationId: Int,
        @JsonProperty("defender_id") val defenderId: Int? = null,
        @JsonProperty("defender_score") val defenderScore: Float? = null,
        @JsonProperty("event_type") val eventType: CampaignEventType,
        @JsonProperty("participants") val participants: List<CampaignParticipant>? = null,
        @JsonProperty("solar_system_id") val solarSystemId: Int,
        @JsonProperty("start_time") val startTime: String,
        @JsonProperty("structure_id") val structureId: Long
)

data class CampaignParticipant (
        @JsonProperty("alliance_id") val allianceId: Int,
        @JsonProperty("score") val score: Float
)

enum class CampaignEventType {
    TCUDefense, IHubDefense, StationDefense, StationFreeport;

    companion object {
        @JsonCreator
        @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}