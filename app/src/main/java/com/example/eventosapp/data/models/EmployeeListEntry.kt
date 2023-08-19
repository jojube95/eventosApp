package com.example.eventosapp.data.models

import com.google.gson.annotations.SerializedName

data class EmployeeListEntry(
    @SerializedName("nombre")
    val nombre: String
)