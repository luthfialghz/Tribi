package com.example.tribiandroid.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tribiandroid.data.RegisterData
import com.example.tribiandroid.data.RegisterResponse
import com.example.tribiandroid.databinding.ActivityRegisterEmailBinding
import com.example.tribiandroid.services.ApiConfig
import com.example.tribiandroid.services.ApiService
import com.example.tribiandroid.ui.MainActivity
import retrofit2.Call
import retrofit2.Response

class RegisterEmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnBack.setOnClickListener {
            Intent(applicationContext, RegisterActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.tvRegisterAnswer.setOnClickListener {
            Intent(applicationContext, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnRegister.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser(){
        val authUsername = binding.etName.text.toString()
        val authPassword = binding.etPassword.text.toString()
        val authEmail = binding.etEmailAddress.text.toString()
        val authDeaf = "false"

        val request = RegisterData()
        request.username = authUsername
        request.password = authPassword
        request.email = authEmail
        request.deaf = authDeaf

        val retrofit = ApiConfig().getRetrofitClientInstance().create(ApiService::class.java)
        retrofit.register(request).enqueue(object : retrofit2.Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                val user = response.body()
                if (user != null){
                    Log.e("onResponse: berhasil", user.message.toString())
                    Toast.makeText(this@RegisterEmailActivity, "Akun berhasil dibuat",Toast.LENGTH_SHORT).show()
                    Intent(this@RegisterEmailActivity, LoginActivity::class.java).also {
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(this@RegisterEmailActivity, "E-mail yang anda masukkan telah digunakan",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
            }

        })
    }
}