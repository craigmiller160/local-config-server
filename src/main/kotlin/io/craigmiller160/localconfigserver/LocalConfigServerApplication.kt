package io.craigmiller160.localconfigserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class LocalConfigServerApplication

fun main(args: Array<String>) {
    runApplication<LocalConfigServerApplication>(*args)
}
