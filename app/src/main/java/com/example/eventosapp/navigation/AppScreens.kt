package com.example.eventosapp.navigation

sealed class AppScreens(val route: String) {
    object EventListScreen: AppScreens("event_list_screen")
    object EmployeeListScreen: AppScreens("employee_list_screen")
}
