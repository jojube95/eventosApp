package com.example.eventosapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EventsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}