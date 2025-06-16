package ru.kalistratov.famalot

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.slf4j.LoggerFactory

private val logger =
    LoggerFactory.getLogger("TEST")

fun main() {
    embeddedServer(
        Netty,
        port = SERVER_PORT,
        host = "0.0.0.0",
        module = Application::module
    )
        .start(wait = true)
}

fun Application.module() {
    logger.debug("START MODULE")
    routing {
        get("/") {
            logger.warn("MAIN -KTOR")
            call.respondText("Ktor: ${Greeting().greet()}")
        }
    }
}