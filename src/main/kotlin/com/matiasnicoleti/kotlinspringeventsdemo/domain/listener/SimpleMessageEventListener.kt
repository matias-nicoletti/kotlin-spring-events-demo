package com.matiasnicoleti.kotlinspringeventsdemo.domain.listener

import com.matiasnicoleti.kotlinspringeventsdemo.domain.event.SimpleMessageEvent
import com.matiasnicoleti.kotlinspringeventsdemo.utils.log
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class SimpleMessageEventListener {
    private val eventRepository: MutableList<SimpleMessageEvent> = mutableListOf()

    fun getEvents(): List<SimpleMessageEvent> =
        listOf(*eventRepository.toTypedArray())

    @EventListener
    fun handleHelloWorldEvent(event: SimpleMessageEvent) {
        eventRepository.add(event)
        log.info("process=events_listener, status=listened, event={}", event)
    }
}
