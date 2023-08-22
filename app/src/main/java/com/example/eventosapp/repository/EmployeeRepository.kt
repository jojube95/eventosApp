package com.example.eventosapp.repository

import com.example.eventosapp.data.models.Employee
import com.example.eventosapp.data.remote.EventApi
import com.example.eventosapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class EmployeeRepository @Inject constructor(
    private val api: EventApi
) {
    suspend fun getEmployees(): Resource<List<Employee>> {
        val response = try {
            api.getEmployeeList()
        } catch(e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}