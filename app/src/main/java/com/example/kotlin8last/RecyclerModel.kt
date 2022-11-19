package com.example.kotlin8last

import java.io.Serializable

data class RecyclerModel(

    var imageUrl: String,
    var name: String,
    var age: Int,
    var family: String

) : Serializable