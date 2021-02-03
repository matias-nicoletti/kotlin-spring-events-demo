package com.matiasnicoleti.kotlinspringeventsdemo.domain.publisher

import com.matiasnicoleti.kotlinspringeventsdemo.domain.event.SimpleMessageEvent
import com.matiasnicoleti.kotlinspringeventsdemo.utils.log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class EventsPublisher(@Autowired private val eventPublisher: ApplicationEventPublisher) {

    fun publishSimpleMessageEvent(event: SimpleMessageEvent) {
        eventPublisher.publishEvent(event)
        log.info("process=events_publisher, status=published, event={}", event)
    }
}
