package com.matiasnicoleti.kotlinspringeventsdemo.infraestructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.SimpleAsyncTaskExecutor

import org.springframework.context.event.SimpleApplicationEventMulticaster

import org.springframework.context.event.ApplicationEventMulticaster

@Configuration
class AsyncEventsConfig {

    @Bean
    fun applicationEventMulticaster(): ApplicationEventMulticaster {
        val eventMulticaster = SimpleApplicationEventMulticaster()
        eventMulticaster.setTaskExecutor(SimpleAsyncTaskExecutor())
        return eventMulticaster
    }
}
