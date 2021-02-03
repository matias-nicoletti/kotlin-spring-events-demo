package com.matiasnicoleti.kotlinspringeventsdemo.domain.event

import org.springframework.context.ApplicationEvent

data class SimpleMessageEvent(val message: String): ApplicationEvent(message)
