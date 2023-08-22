package com.example.eventosapp.employeelist

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eventosapp.data.models.Employee

@Composable
fun EmployeeListScreen(employeeListViewModel: EmployeeListViewModel = hiltViewModel()) {
    Scaffold {
        BodyContent(employeeListViewModel)
    }
}

@Composable
fun BodyContent(employeeListViewModel: EmployeeListViewModel){
    Column() {
        val employeeList = employeeListViewModel.employeeList.observeAsState()

        LaunchedEffect(key1 = null) {
            employeeListViewModel.fetchEmployees()
        }
        Column() {
            employeeList.value?.forEach { employeeListEntry ->
                Employee(employeeListEntry)
            }
        }
    }
}

@Composable
fun Employee(employee: Employee){
    Card(elevation = 10.dp,
        modifier = Modifier.padding(10.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(start=16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.fillMaxWidth()) {
                // Encabezado
                Text(text = employee.person.name, style = MaterialTheme.typography.h6)

                // Subtítulo
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = employee.type.value, style = MaterialTheme.typography.body1)
                }
            }
        }
    }
}