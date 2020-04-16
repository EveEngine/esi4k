package net.legio.esi4k

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.fasterxml.jackson.module.kotlin.readValue
import java.time.Instant

sealed class TokenVerify{
    enum class Error {
        VERIFY_ERROR,
        AUTHORIZATION_NOT_PROVIDED,
        UNSUPPORTED_DATASOURCE,
        OTHER
    }
    companion object {
        /**
         * Attempts to validate the access token of the client. If the access  token is
         */
        @JvmStatic
        internal fun verify(esiResponse: ESIResponse): TokenVerify?{
            when(esiResponse){
                is ESISuccessResponse -> return jacksonObjectMapper().readValue(esiResponse.content, jacksonTypeRef<TokenVerified>())
                is ESIFailResponse -> {
                    val body: Map<String,String> = jacksonObjectMapper().readValue(esiResponse.content)
                    return when(esiResponse.code){
                        400 -> {
                            TokenInvalid(Error.VERIFY_ERROR, esiResponse.errorMessage, body["error_description"])
                        }
                        401 -> {
                            TokenInvalid(Error.AUTHORIZATION_NOT_PROVIDED, esiResponse.errorMessage)
                        }
                        404 -> {
                            TokenInvalid(Error.UNSUPPORTED_DATASOURCE, esiResponse.errorMessage)
                        }
                        else -> {
                            TokenInvalid(Error.OTHER, "An unexpected error occurred")
                        }
                    }
                }
            }
        }
    }
}

data class TokenVerified(
    @JsonProperty("CharacterId") val characterId: Int,
    @JsonProperty("CharacterName") val characterName: String? = null,
    @JsonProperty("CharacterOwnerHash") val characterOwnerHash: String? = null,
    @JsonProperty("ExpiresOn") val expiresOn: Instant? = null,
    @JsonProperty("IntellectualProperty") val intellectualProperty: String? = null,
    @JsonProperty("Scopes") val scopes: String? = null,
    @JsonProperty("TokenType") val tokenType: String? = null
) : TokenVerify() {
    val scopesArray: Array<String> = scopes?.split(" ")?.toTypedArray()?:arrayOf()
}

class TokenInvalid internal constructor(
    val error: Error,
    var errorMessage: String? = null,
    var detailedMessage: String? = null
): TokenVerify()