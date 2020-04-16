package net.legio.esi4k.app

import net.legio.esi4k.*
import net.legio.esi4k.resource.AllianceResources

class Application {

    fun start(){
        val client = ESIClient().apply {
            accessToken = "foo"
            applyUserAgentPerRequest = true
            clientId = "my_client"
        }
        println("Created client, verifying bad token")
        val tokenVerify = client.verifyAuthentication()
        when(tokenVerify){
            is TokenVerified -> println("Token Verified: ${tokenVerify.toString()}")
            is TokenInvalid -> println("Token verify failed: ${tokenVerify.error} - ${tokenVerify.errorMessage}")
            null -> println("No token to verify")
        }
    }

}

fun main(args: Array<String>){
    Application().start()
}