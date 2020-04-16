package net.legio.esi4k

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AuthRequiredResources {
    protected lateinit var testProps: TestProps
    protected val esiClient = ESIClient()

    /**
     * @throws TestPropertiesException when an error occurs when loading the test.properties file.
     */
    @BeforeAll
    @Throws(TestPropertiesException::class)
    protected fun setup(){
        testProps = TestProps.instance()
        esiClient.accessToken = testProps.resourcesToken
        esiClient.clientId = testProps.clientId
    }

}