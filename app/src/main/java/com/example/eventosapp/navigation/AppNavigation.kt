package com.example.eventosapp.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eventosapp.employeelist.EmployeeListScreen
import com.example.eventosapp.eventlist.EventListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar() {
                IconButton(onClick = { navController.navigate(route = AppScreens.EventListScreen.route) },
                    modifier = Modifier.weight(1f).fillMaxSize()) {
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Events")
                }
                IconButton(onClick = { navController.navigate(route = AppScreens.EmployeeListScreen.route) },
                    modifier = Modifier.weight(1f).fillMaxSize()) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Employees")
                }
            }
        }
    ) {
        NavHost(navController=navController, startDestination = AppScreens.EventListScreen.route) {
            composable(route = AppScreens.EventListScreen.route){
                EventListScreen()
            }
            composable(route = AppScreens.EmployeeListScreen.route){
                EmployeeListScreen()
            }
        }
    }
}