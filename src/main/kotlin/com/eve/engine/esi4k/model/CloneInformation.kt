package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonProperty

open class CloneInformation(
    @JsonProperty("home_location") val homeLocation: CloneHomeLocation? = null,
    @JsonProperty("jump_clones") val jumpClones: List<JumpClone>,
    @JsonProperty("last_clone_jump_date") val lastCloneJumpDate: String? = null,
    @JsonProperty("last_station_change_date") val lastStationChangeDate: String? = null
)

open class CloneHomeLocation(
    @JsonProperty("location_id") val locationId: Float? = null,
    @JsonProperty("location_type") val locationType: LocationType? = null
)

open class JumpClone(
    @JsonProperty("implants") val implants: List<Int>,
    @JsonProperty("jump_clone_id") val jumpCloneId: Int,
    @JsonProperty("location_id") val locationId: Int,
    @JsonProperty("location_type") val locationType: LocationType,
    @JsonProperty("name") val name: String? = null
)