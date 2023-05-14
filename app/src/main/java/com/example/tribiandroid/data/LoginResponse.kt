package com.example.tribiandroid.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: DataLogin? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataLogin(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
