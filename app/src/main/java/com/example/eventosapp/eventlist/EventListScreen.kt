package com.example.eventosapp.eventlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eventosapp.data.models.Event
import com.example.eventosapp.navigation.AppScreens
import java.util.*

@Composable
fun EventListScreen(eventListViewModel: EventListViewModel = hiltViewModel()) {
    Scaffold (
        topBar = {
            TopAppBar() {
                IconButton(onClick = { eventListViewModel.openYearDialog() },
                    modifier = Modifier.weight(1f).fillMaxSize()) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                }
                IconButton(onClick = { println("Add") },
                    modifier = Modifier.weight(1f).fillMaxSize()) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                }
            }
    }){
        BodyContent(eventListViewModel)
        YearDialog(eventListViewModel)
    }
}

@Composable
fun BodyContent(eventListViewModel: EventListViewModel){
    Column() {
        val eventList = eventListViewModel.eventList.observeAsState()

        LaunchedEffect(key1 = null) {
            eventListViewModel.fetchEvents(eventListViewModel.currentYear)
        }
        Column() {
            eventList.value?.forEach { eventListEntry ->
                Event(eventListEntry)
            }
        }
    }
}

@Composable
fun Event(event: Event){
    Card(elevation = 10.dp,
    modifier = Modifier.padding(10.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(start=16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Miniatura
            Box(
                modifier =Modifier
                    .background(color=Color.Black, shape=CircleShape)
                    .size(50.dp),
                contentAlignment = Alignment.Center
            ) {
                val cal: Calendar=Calendar.getInstance()
                cal.time=event.fecha

                Text(text = "${cal.get(Calendar.DAY_OF_MONTH)}/${cal.get(Calendar.MONTH) + 1}")
            }

            Spacer(modifier = Modifier.width(32.dp))

            Column(Modifier.fillMaxWidth()) {
                // Encabezado
                Text(text = event.titulo, style = MaterialTheme.typography.h6)

                // Subtítulo
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = event.descripcion, style = MaterialTheme.typography.body1)
                }
            }
        }

    }
}

@Composable
fun YearDialog(eventListViewModel: EventListViewModel){
    if (eventListViewModel.dialogState.value) {
        Dialog(onDismissRequest={ eventListViewModel.closeYearDialog() }) {
            Column() {
                Card(
                    modifier=Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(16.dp),
                    shape=RoundedCornerShape(16.dp),
                ) {
                    Column(modifier=Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)) {
                        Button(onClick={ eventListViewModel.yearOnClick(2021) }) {
                            Text(text="2021")
                        }
                        Button(onClick={ eventListViewModel.yearOnClick(2022) }) {
                            Text(text="2022")
                        }
                        Button(onClick={ eventListViewModel.yearOnClick(2023) }) {
                            Text(text="2023")
                        }
                    }

                }
            }
        }
    }
}