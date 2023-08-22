package com.example.eventosapp.employeelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventosapp.data.models.Employee
import com.example.eventosapp.data.models.Event
import com.example.eventosapp.repository.EmployeeRepository
import com.example.eventosapp.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeListViewModel @Inject constructor(
    private val employeeRepository: EmployeeRepository
): ViewModel() {
    private val _employeeList = MutableLiveData<List<Employee>>()
    val employeeList: LiveData<List<Employee>>
        get() = _employeeList

    init {
        fetchEmployees()
    }

    fun fetchEmployees() {
        viewModelScope.launch {
            _employeeList.value = employeeRepository.getEmployees().data
        }
    }
}