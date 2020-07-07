package net.legio.esi4k;

import com.eve_engine.esi4k.ESIClient
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
