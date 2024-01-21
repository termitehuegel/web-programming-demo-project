package de.philipberner.hwr.webprg

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ComponentScan
@ComponentScan("de.philipberner")
@ConfigurationPropertiesScan("de.philipberner")
@SpringBootApplication
open class DemoProjectApplication

fun main(args: Array<String>) {
    SpringApplication(DemoProjectApplication::class.java)
        .run(*args)
}

inline fun <reified T> T.logger(): Logger {
    return LoggerFactory.getLogger(T::class.java)
}