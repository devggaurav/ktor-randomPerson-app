package com.gc.personsapp.data

import retrofit2.http.GET

interface PersonsApi {

    @GET("/randomPerson")
     suspend fun getRandomPerson() : Person

     companion object{
         const val BASE_URL = "http://192.168.1.31:8100"
     }

}