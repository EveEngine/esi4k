package com.eve.engine.esi4k.resource

import com.sun.java.accessibility.util.EventID
import com.eve.engine.esi4k.*
import com.eve.engine.esi4k.model.Attendee
import com.eve.engine.esi4k.model.Event
import com.eve.engine.esi4k.model.EventResponse
import com.eve.engine.esi4k.model.EventSummary

class CalendarResources(esiClient: ESIClient,  datasource: Datasource): ESIResources(esiClient,  datasource) {

    fun eventSummariesRaw(characterId: Int, fromEvent: Int = 0): ESIResponse {
        return with(createRequest("/characters/$characterId/calendar", authorization = true)){
            if(fromEvent > 0) addQueryParam("from_event", fromEvent.toString())
            execute()
        }
    }

    fun eventSummaries(characterId: Int, fromEvent: Int = 0): ReifyResult<List<EventSummary>> {
        return eventSummaries(eventSummariesRaw(characterId, fromEvent))
    }

    fun eventSummaries(esiResponse: ESIResponse): ReifyResult<List<EventSummary>> {
        return responseToEntityList(esiResponse)
    }

    fun eventRaw(characterId: Int, eventId: Int): ESIResponse {
        return callExecute("/characters/$characterId/calendar/$eventId")
    }

    fun event(characterId: Int, eventId: Int): ReifyResult<Event> {
        return event(eventRaw(characterId, eventId))
    }

    fun event(esiResponse: ESIResponse): ReifyResult<Event> {
        return responseToEntity(esiResponse)
    }

    fun respondToEvent(characterId: Int, eventId: Int, response: EventResponse): ESIResponse {
        return with(createRequest("/characters/$characterId/calendar/$eventId", HttpMethod.PUT)){
            body = mapper.writeValueAsString(Pair("response", "$response"))
            execute()
        }
    }

    fun attendeesRaw(characterId: Int, eventId: Int): ESIResponse {
        return callExecute("/characters/$characterId/calendar/$eventId/attendees")
    }

    fun attendees(characterId: Int, eventId: Int): ReifyResult<List<Attendee>> {
        return attendees(attendeesRaw(characterId, eventId))
    }

    fun attendees(esiResponse: ESIResponse): ReifyResult<List<Attendee>> {
        return responseToEntityList(esiResponse)
    }

}