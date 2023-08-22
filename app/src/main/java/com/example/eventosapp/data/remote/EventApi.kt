package com.example.eventosapp.data.remote

import com.example.eventosapp.data.models.Employee
import com.example.eventosapp.data.models.Event
import retrofit2.http.GET
import retrofit2.http.Query

interface EventApi {

    @GET("eventos")
    suspend fun getEventList(
        @Query("year") year: Int
    ): List<Event>

    @GET("empleados")
    suspend fun getEmployeeList(): List<Employee>
}