package net.legio.esi4k

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.fasterxml.jackson.module.kotlin.readValue
import java.time.Instant

sealed class TokenVerify{
    /** The error indicated by the response code from the response. */
    enum class Error(val code: Int) {
        VERIFY_ERROR(400),
        AUTHORIZATION_NOT_PROVIDED(401),
        UNSUPPORTED_DATASOURCE(404),
        OTHER(0)
    }
    companion object {
        /**
         * Calls the ESI server to verify and validate the access token of the client.
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

/**
 * Indicates the access token was successfully verified by the ESI server.
 */
data class TokenVerified(
        /** Token owner's character ID */
        @JsonProperty("CharacterId") val characterId: Int,
        /** Token owner's character name */
        @JsonProperty("CharacterName") val characterName: String? = null,
        /** Hash of the character's owner. If the character is sold or otherwise transferred, this will change */
        @JsonProperty("CharacterOwnerHash") val characterOwnerHash: String? = null,
        /** Expiry time of the token (not RFC3339) */
        @JsonProperty("ExpiresOn") val expiresOn: Instant? = null,
        /** The IP which generated the token */
        @JsonProperty("IntellectualProperty") val intellectualProperty: String? = null,
        /** Space separated list of scopes the token is valid for */
        @JsonProperty("Scopes") val scopes: String? = null,
        /** Type of access token */
        @JsonProperty("TokenType") val tokenType: String? = null
) : TokenVerify() {
    /** The parsed array of scopes (see [scopes])*/
    val scopesArray: Array<String> = scopes?.split(" ")?.toTypedArray()?:arrayOf()
}

/**
 * Indicates that the token was not able to verify correctly.
 */
class TokenInvalid internal constructor(
        /** The [Error] type received from the ESI server. */
        val error: Error,
        /** The message received from the server. */
        var errorMessage: String? = null,
        /** The description of the error if provided by the response. */
        var detailedMessage: String? = null
): TokenVerify()