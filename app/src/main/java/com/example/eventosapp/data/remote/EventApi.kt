package com.example.eventosapp.data.remote

import com.example.eventosapp.data.models.EmployeeListEntry
import com.example.eventosapp.data.models.EventListEntry
import retrofit2.http.GET
import retrofit2.http.Query

interface EventApi {

    @GET("eventos")
    suspend fun getEventList(
        @Query("year") year: Int
    ): List<EventListEntry>

    @GET("empleados")
    suspend fun getEmployeeList(): List<EmployeeListEntry>
}