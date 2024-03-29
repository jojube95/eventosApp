package com.example.eventosapp.repository

import com.example.eventosapp.data.models.Event
import com.example.eventosapp.data.remote.EventApi
import com.example.eventosapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class EventRepository @Inject constructor(
    private val api: EventApi
) {
    suspend fun getEvents(year: Int): Resource<List<Event>> {
        val response = try {
            api.getEventList(year)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}