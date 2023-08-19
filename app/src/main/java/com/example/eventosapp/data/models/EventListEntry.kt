package com.example.eventosapp.data.models

import com.google.gson.annotations.SerializedName

data class EventListEntry(
    @SerializedName("titulo")
    val titulo: String,
    @SerializedName("localidad")
    val localidad: String
)