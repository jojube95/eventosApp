package com.example.eventosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.Text
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
                // A surface container using the 'background' color from the theme
                Surface(modifier=Modifier.fillMaxSize(), color=MaterialTheme.colors.background) {
                    Column() {
                        Row() {
                            Tab(selected=true, onClick={ /*TODO*/ }) {
                                Text(text="Events")
                            }
                            Tab(selected=false, onClick={ /*TODO*/ }) {
                                Text(text="Employees")
                            }
                        }
                        AppNavigation()
                    }

                }
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