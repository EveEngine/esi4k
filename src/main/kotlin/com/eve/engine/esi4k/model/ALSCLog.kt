package com.eve.engine.esi4k.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

/** Alliance Secure Container Log */
open class ALSCLog (
    @JsonProperty("action") val action: LogAction,
    @JsonProperty("character_id") val characterId: Int,
    @JsonProperty("container_id") val containerId: Long,
    @JsonProperty("container_type_id") val containerTypeId: Int,
    @JsonProperty("location_flag") val locationFlag: LocationFlag,
    @JsonProperty("location_id") val locationId: Long,
    @JsonProperty("logged_at") val lagged_at: String,
    @JsonProperty("new_config_bitmask") val newConfigBitmask: Int? = null,
    @JsonProperty("old_config_bitmask") val oldConfigBitmask: Int? = null,
    @JsonProperty("password_type") val passwordType: PasswordType? = null,
    @JsonProperty("quantity") val quantity: Int? = null,
    @JsonProperty("type_id") val typeId: Int? = null
)

enum class LogAction {
    Add, Assemble, Configure, EnterPassword, Lock, Move, Repackage, SetName, SetPassword, Unlock;

    companion object {
        @JsonCreator
        @JvmStatic fun fromRaw(raw: String): ContractType{
            val corrected = raw.replace("_", "").toLowerCase()
            return ContractType.values().first{ t -> t.name.toLowerCase() == corrected }
        }
    }
}

enum class PasswordType {
    Config, General
}