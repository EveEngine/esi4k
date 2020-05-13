package net.legio.esi4k.resource

import net.legio.esi4k.*
import net.legio.esi4k.model.MailDetails

class UserInterfaceResources(client: ESIClient,  datasource: Datasource = Datasource.TRANQUILITY): ESIResources(client,  datasource) {

    fun setAutopilotWaypoint(destinationId: Int, clearOtherWaypoints: Boolean, addToBeginning: Boolean): ESIResponse {
        return with(createRequest("/ui/auotpilot/waypoint",HttpMethod.POST, true)) {
            addQueryParam("destination_id", destinationId.toString())
            addQueryParam("add_to_beginning", addToBeginning.toString())
            addQueryParam("clear_other_waypoints", clearOtherWaypoints.toString())
            execute()
        }
    }

    fun openContractWindow(contractId: Int): ESIResponse {
        return with(createRequest("/ui/openwindow/contract", HttpMethod.POST, true)) {
            addQueryParam("contract_id", contractId.toString())
            execute()
        }
    }

    fun openInformationWindow(targetId: Int): ESIResponse {
        return with(createRequest("/ui/openwindow/information",HttpMethod.POST, true)){
            addQueryParam("target_id", targetId.toString())
            execute()
        }
    }

    fun openMarketDetailsWindow(typeId: Int): ESIResponse {
        return with(createRequest("/ui/openwindow/marketdetails", HttpMethod.POST, true)) {
            addQueryParam("type_id", typeId.toString())
            execute()
        }
    }

    fun openNewMailWindow(mailDetails: MailDetails): ESIResponse {
        return with(createRequest("/ui/openwindow/newmail", HttpMethod.POST, true)) {
            body = mapper.writeValueAsString(mailDetails)
            execute()
        }
    }
}