package com.example.tribiandroid.data

import com.google.gson.annotations.SerializedName

data class RegisterData(

	@field:SerializedName("password")
	var password: String? = null,

	@field:SerializedName("deaf")
	var deaf: String? = null,

	@field:SerializedName("email")
	var email: String? = null,

	@field:SerializedName("username")
	var username: String? = null
)
