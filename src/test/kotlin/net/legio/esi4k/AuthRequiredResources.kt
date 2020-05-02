package net.legio.esi4k

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import java.lang.IllegalArgumentException

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AuthRequiredResources {
    protected lateinit var authTestProps: AuthTestProps
    protected val esiClient = ESIClient()

    /**
     * @throws TestPropertiesException when an error occurs when loading the test.properties file.
     */
    @BeforeAll
    @Throws(TestPropertiesException::class)
    protected fun setup(){
        authTestProps = AuthTestProps.instance()
        if(authTestProps.accessToken.isBlank()) throw IllegalArgumentException("access token must be set")
        if(authTestProps.clientId.isBlank()) throw IllegalArgumentException("client id must be set")
        if(authTestProps.allianceId == -1) throw IllegalArgumentException("alliance id must be set")
        if(authTestProps.characterId == -1) throw IllegalArgumentException("character id must be set")
        if(authTestProps.corporationId == -1) throw IllegalArgumentException("corporation id must be set")

        esiClient.accessToken = authTestProps.accessToken
        esiClient.clientId = authTestProps.clientId
    }

}