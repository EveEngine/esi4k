package net.legio.esi4k

import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

class AuthTestProps private constructor(){
    val accessToken: String
    val clientId: String
    val allianceId: Int
    val characterId: Int
    val corporationId: Int

    init {
        val testPropertiesFilePath = this.javaClass.classLoader.getResource("test.properties")?.path
        if(testPropertiesFilePath.isNullOrEmpty()){
            val environment = System.getenv()
            accessToken = environment[RESOURCES_AUTH_TOKEN_ENV]?:""
            clientId = environment[ESI_CLIENT_CLIENT_ID_ENV]?:""
            allianceId = environment[RESOURCES_ALLIANCE_ID_ENV]?.toInt()?:-1
            characterId = environment[RESOURCES_CHARACTER_ID_ENV]?.toInt()?:-1
            corporationId = environment[RESOURCES_CORPORATION_ID_ENV]?.toInt()?:-1
        }else {
            val propsFilePath = Paths.get(testPropertiesFilePath.substring(1))
            val properties: Properties
            try {
                properties = Properties().apply { load(FileReader(propsFilePath.toFile())) }
            }catch (e: FileNotFoundException){
                throw TestPropertiesException("Missing test.properties file. Create this file with required testing properties in the /resources folder or initialize environemnt variables.")
            }catch (e: IOException){
                throw TestPropertiesException("An error occurred reading test.properties file: ${e.message}")
            }
            accessToken = properties.getProperty(RESOURCES_AUTH_TOKEN_KEY)
            clientId = properties.getProperty(ESI_CLIENT_CLIENT_ID_KEY)
            allianceId = properties.getProperty(RESOURCES_ALLIANCE_ID_KEY).toInt()
            characterId = properties.getProperty(RESOURCES_CHARACTER_ID_KEY).toInt()
            corporationId = properties.getProperty(RESOURCES_CORPORATION_ID_KEY).toInt()
        }
    }

    companion object {
        private var instance: AuthTestProps? = null
        const val ESI_CLIENT_CLIENT_ID_KEY = "esi.client.clientid"
        const val ESI_CLIENT_CLIENT_ID_ENV = "ESI_CLIENT_CLIENT_ID"
        const val RESOURCES_AUTH_TOKEN_KEY = "esi.client.token"
        const val RESOURCES_AUTH_TOKEN_ENV = "ESI_AUTH_TOKEN"
        const val RESOURCES_ALLIANCE_ID_KEY = "resources.alliance.id"
        const val RESOURCES_ALLIANCE_ID_ENV = "RESOURCES_ALLIANCE_ID"
        const val RESOURCES_CHARACTER_ID_KEY = "resources.character.id"
        const val RESOURCES_CHARACTER_ID_ENV = "RESOURCES_CHARACTER_ID"
        const val RESOURCES_CORPORATION_ID_KEY = "resources.corporation.id"
        const val RESOURCES_CORPORATION_ID_ENV = "RESOURCES_CORPORATION_ID"
        @JvmStatic
        fun instance(): AuthTestProps {
            if(instance == null) instance = AuthTestProps()
            return instance!!
        }

    }
}