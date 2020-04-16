package net.legio.esi4k

import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

class TestProps private constructor(){
    val resourcesToken: String
    val clientId: String
    val allianceId: Int
    val characterId: Int
    val corporationId: Int

    init {
        val testPropertiesFilePath = this.javaClass.classLoader.getResource("test.properties")?.path?: throw TestPropertiesException("Missing test.properties file. Create this file with required testing properties in the /resources folder.")
        val propsFilePath = Paths.get(testPropertiesFilePath )
        if(Files.exists(propsFilePath)) {
            val properties: Properties
            try {
                properties = Properties().apply { load(FileReader(propsFilePath.toFile())) }
            }catch (e: FileNotFoundException){
                throw TestPropertiesException("Missing test.properties file. Create this file with required testing properties in the /resources folder.")
            }catch (e: IOException){
                throw TestPropertiesException("An error occurred reading test.properties file: ${e.message}")
            }
            resourcesToken = properties.getProperty(RESOURCES_AUTH_TOKEN_KEY)
            clientId = properties.getProperty(ESI_CLIENT_CLIENT_ID_KEY)
            allianceId = properties.getProperty(RESOURCES_ALLIANCE_ID_KEY).toInt()
            characterId = properties.getProperty(RESOURCES_CHARACTER_ID_KEY).toInt()
            corporationId = properties.getProperty(RESOURCES_CORPORATION_ID_KEY).toInt()
        }else{
            throw TestPropertiesException("Missing test.properties file. Create this file with required testing properties in the /resources folder.")
        }
    }

    companion object {
        private var instance: TestProps? = null
        const val ESI_CLIENT_CLIENT_ID_KEY = "esi.client.clientid"
        const val RESOURCES_AUTH_TOKEN_KEY = "esi.client.token"
        const val RESOURCES_ALLIANCE_ID_KEY = "resources.alliance.id"
        const val RESOURCES_CHARACTER_ID_KEY = "resources.character.id"
        const val RESOURCES_CORPORATION_ID_KEY = "resources.corporation.id"
        @JvmStatic
        fun instance() = instance?:TestProps()
    }
}