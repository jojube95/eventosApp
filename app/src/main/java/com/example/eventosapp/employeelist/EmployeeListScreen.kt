package com.example.eventosapp.employeelist

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun EmployeeListScreen(navController: NavController) {
    Scaffold {
        BodyContent()
    }
}

@Composable
fun BodyContent(){
    Column() {
        Text(text="EmployeeList")
    }
}