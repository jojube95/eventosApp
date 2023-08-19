package com.example.eventosapp.eventlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.eventosapp.navigation.AppScreens

@Composable
fun EventListScreen(navController: NavController, eventListViewModel: EventListViewModel = hiltViewModel()) {
    Scaffold {
        BodyContent(eventListViewModel, navController)
    }
}

@Composable
fun BodyContent(eventListViewModel: EventListViewModel, navController: NavController){
    Column() {
        val eventList = eventListViewModel.eventList.observeAsState()

        LaunchedEffect(key1 = null) {
            eventListViewModel.fetchBooks()
        }
        Column() {
            eventList.value?.forEach { eventListEntry ->
                Text(text=eventListEntry.titulo)
            }
        }
        Button(onClick={
            navController.navigate(route = AppScreens.EmployeeListScreen.route)
        }) {
            Text(text="EmployeeList")
        }
    }
}