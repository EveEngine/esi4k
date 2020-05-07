package net.legio.esi4k.resource

import net.legio.esi4k.Datasource
import net.legio.esi4k.ESIClient
import net.legio.esi4k.Version
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("public contract resources tests")
class ContractResourcesTests {

    private val esiClient = ESIClient()
    private val contractsResources = ContractsResources(esiClient, Version.LATEST, Datasource.TRANQUILITY)

    @Test
    fun `should get public contracts from region`() {
    }
}