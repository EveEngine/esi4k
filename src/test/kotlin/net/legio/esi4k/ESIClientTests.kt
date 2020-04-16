package net.legio.esi4k;

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ESIClientTests {

    private val esiClient = ESIClient()

    @Test
    fun `esi client should ping server`() {
        assert(esiClient.ping()){
            "Failed to ping ESI Server"
        }
    }

}
