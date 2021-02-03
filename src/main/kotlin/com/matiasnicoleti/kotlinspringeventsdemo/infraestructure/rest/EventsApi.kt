package com.matiasnicoleti.kotlinspringeventsdemo.infraestructure.rest

import com.matiasnicoleti.kotlinspringeventsdemo.domain.publisher.EventsPublisher
import com.matiasnicoleti.kotlinspringeventsdemo.domain.event.SimpleMessageEvent
import com.matiasnicoleti.kotlinspringeventsdemo.domain.listener.SimpleMessageEventListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody

@RestController
class EventsApi(
    @Autowired private val eventsPublisher: EventsPublisher,
    @Autowired private val simpleMessageEventListener: SimpleMessageEventListener
) {

    @PostMapping("/simple-message-event")
    fun publishSimpleMessageEvent(@RequestBody request: HelloWorldEventRequest): ResponseEntity<*> {
        val event = request.toEvent()
        eventsPublisher.publishSimpleMessageEvent(event)
        return ResponseEntity.ok(event)
    }

    @GetMapping("/simple-message-event")
    fun getSimpleMessageEvents(): ResponseEntity<*> {
        return ResponseEntity.ok(simpleMessageEventListener.getEvents())
    }
}

data class HelloWorldEventRequest(val message: String)
fun HelloWorldEventRequest.toEvent() = SimpleMessageEvent(message)

