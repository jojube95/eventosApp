package com.example.eventosapp.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Person(
    @SerializedName("nombre")
    val name: String,
    @SerializedName("telefono")
    val number: String,
    @SerializedName("correo")
    val email: String
)