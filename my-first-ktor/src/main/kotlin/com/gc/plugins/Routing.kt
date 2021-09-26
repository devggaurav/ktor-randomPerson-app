package com.gc.plugins

import com.gc.routes.randomPerson
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    

    routing {
       /* get("/") {
                call.respondText("Hello World!")
            }*/
         randomPerson()

        // Static plugin. Try to access `/static/index.html`
       /* static("/static") {
            resources("static")
        }*/

        static {
            resources("static")
        }
    }
}
