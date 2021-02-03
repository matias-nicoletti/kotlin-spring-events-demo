package com.matiasnicoleti.kotlinspringeventsdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class KotlinSpringEventsDemoApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringEventsDemoApplication>(*args)
}
