package com.gc.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Person(

    val name : String,
    val description : String,
    val imageUrl: String

)
