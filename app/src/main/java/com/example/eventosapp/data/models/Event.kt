package com.example.eventosapp.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Event(
    @SerializedName("titulo")
    val titulo: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("fecha")
    val fecha: Date

)