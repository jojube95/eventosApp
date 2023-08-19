package com.example.eventosapp.eventlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventosapp.data.models.EventListEntry
import com.example.eventosapp.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventListViewModel @Inject constructor(
    private val eventRepository: EventRepository
): ViewModel() {
    private val _eventList = MutableLiveData<List<EventListEntry>>()
    val eventList: LiveData<List<EventListEntry>>
        get() = _eventList

    init {
        fetchBooks()
    }

    fun fetchBooks() {
        viewModelScope.launch {
            _eventList.value = eventRepository.getEvents(2022).data
        }
    }
}