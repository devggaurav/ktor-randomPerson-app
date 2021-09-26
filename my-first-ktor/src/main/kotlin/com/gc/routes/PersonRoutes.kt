package com.gc.routes

import com.gc.data.model.Person
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private const val BASE_URL = "http://192.168.1.31:8100"
private val persons = listOf(
    Person("Emma","A software Engineer","$BASE_URL/persons/person1.jpeg"),
            Person("Nicol","A Mechanical Engineer,who likes tools","$BASE_URL/persons/person2.jpeg"),
Person("Chloe","A Designer, who like to make sketches","$BASE_URL/persons/person3.jpeg"),
    Person("Fatima","A Bikers,who like to ride bikes and cars","$BASE_URL/persons/person4.jpeg"),
    Person("Jane","A writer, who like to write stories about people","$BASE_URL/persons/person5.jpeg")
)

fun Route.randomPerson(){

    get("/randomPerson"){
      call.respond(HttpStatusCode.OK,
      persons.random()

          )

    }
}