package com.example.tribiandroid.services

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    fun getRetrofitClientInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://api.tribi.adaptivenetworklab.org/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}