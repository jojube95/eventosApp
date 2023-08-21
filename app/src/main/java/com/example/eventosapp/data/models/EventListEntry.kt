package com.example.eventosapp.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class EventListEntry(
    @SerializedName("titulo")
    val titulo: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("fecha")
    val fecha: Date

)