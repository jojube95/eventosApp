package com.example.eventosapp.di

import com.example.eventosapp.data.remote.EventApi
import com.example.eventosapp.repository.EventRepository
import com.example.eventosapp.util.Constants.BASE_URL
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideEventRepository(
        api: EventApi
    ) = EventRepository(api)

    @Singleton
    @Provides
    fun provideEventApi(): EventApi {
        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()

        val client = OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor("admin", "admin"))
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(EventApi::class.java)
    }
}