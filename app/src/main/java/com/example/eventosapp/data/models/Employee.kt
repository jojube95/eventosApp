package com.example.eventosapp.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class Employee(
    @SerializedName("tipo")
    val type: EmployeeType,
    @SerializedName("persona")
    val person: Person
)