package com.example.eventosapp.eventlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventosapp.data.models.Event
import com.example.eventosapp.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class EventListViewModel @Inject constructor(
    private val eventRepository: EventRepository
): ViewModel() {
    private val _eventList = MutableLiveData<List<Event>>()
    val eventList: LiveData<List<Event>>
        get() = _eventList

    val dialogState by lazy { mutableStateOf(false) }
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)


    init {
        fetchEvents(currentYear)
    }

    fun fetchEvents(year: Int) {
        viewModelScope.launch {
            _eventList.value = eventRepository.getEvents(year).data
        }
    }

    fun yearOnClick(year: Int) {
        fetchEvents(year)
        closeYearDialog()
    }

    fun closeYearDialog() {
        dialogState.value = false
    }

    fun openYearDialog() {
        dialogState.value = true
    }
}