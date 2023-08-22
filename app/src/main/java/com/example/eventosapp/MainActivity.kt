package com.example.eventosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eventosapp.navigation.AppNavigation
import com.example.eventosapp.ui.theme.EventosAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventosAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text="Hello $name!")
}

@Preview(showBackground=true)
@Composable
fun DefaultPreview() {
    EventosAppTheme {
        Greeting("Android")
    }
}