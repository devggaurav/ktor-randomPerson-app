package com.gc.personsapp.di

import com.gc.personsapp.data.PersonsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providePersonApi(): PersonsApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
            PersonsApi.BASE_URL).build().create(PersonsApi::class.java)
    }
}