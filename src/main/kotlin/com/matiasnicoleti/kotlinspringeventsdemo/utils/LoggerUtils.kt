package com.matiasnicoleti.kotlinspringeventsdemo.utils

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Suppress("unused")
inline val <reified T> T.log: Logger
    get() = LogManager.getLogger(T::class.java)
