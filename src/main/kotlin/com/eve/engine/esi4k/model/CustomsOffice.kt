package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CustomsOffice (
        @JsonProperty("alliance_tax_rate") val allianceTaxRate: Float? = null,
        @JsonProperty("allow_access_with_standings") val allowAccessWithStandings: Boolean,
        @JsonProperty("allow_alliance_access") val allowAllianceAccess: Boolean,
        @JsonProperty("bad_standing_tax_rate") val badStandingTaxRate: Float? = null,
        @JsonProperty("corporation_tax_rate") val corporationTaxRate: Float? = null,
        @JsonProperty("excellent_standing_tax_rate") val excellentStandingTaxRate: Float? = null,
        @JsonProperty("good_standing_tax_rate") val goodStandingTaxRate: Float? = null,
        @JsonProperty("neutral_standing_tax_rate") val neutralStandingTaxRate: Float? = null,
        @JsonProperty("office_id") val officeId: Long,
        @JsonProperty("reinforce_exit_end") val reinforceExitEnd: Int,
        @JsonProperty("reinforce_exit_start") val reinforceExitStart: Int,
        @JsonProperty("standing_level") val standingLevel: StandingLevel? = null,
        @JsonProperty("system_id") val systemId: Int,
        @JsonProperty("terrible_standing_tax_rate") val terribleStandingTaxRate: Float? = null
)

enum class StandingLevel {
    Bad, Excellent, Good, Neutral, Terrible
}