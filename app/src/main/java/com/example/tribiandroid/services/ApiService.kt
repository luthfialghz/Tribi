package com.example.tribiandroid.services

import android.telecom.Call
import com.example.tribiandroid.data.LoginData
import com.example.tribiandroid.data.LoginResponse
import com.example.tribiandroid.data.RegisterData
import com.example.tribiandroid.data.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("api/signup")
    fun register(
        @Body userRegister: RegisterData
    ): retrofit2.Call<RegisterResponse>

    @POST("api/signin")
    fun login(
        @Body userLogin: LoginData
    ): retrofit2.Call<LoginResponse>
}