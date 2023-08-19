package com.example.eventosapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eventosapp.employeelist.EmployeeListScreen
import com.example.eventosapp.eventlist.EventListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = AppScreens.EventListScreen.route) {
        composable(route = AppScreens.EventListScreen.route){
            EventListScreen(navController)
        }
        composable(route = AppScreens.EmployeeListScreen.route){
            EmployeeListScreen(navController)
        }
    }
}