package com.example.tribiandroid.data

import com.google.gson.annotations.SerializedName

data class LoginData(

	@field:SerializedName("password")
    var password: String? = null,

	@field:SerializedName("email")
	var email: String? = null
)
