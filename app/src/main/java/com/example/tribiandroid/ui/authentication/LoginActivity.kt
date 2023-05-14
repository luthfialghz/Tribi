package com.example.tribiandroid.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tribiandroid.R
import com.example.tribiandroid.data.LoginData
import com.example.tribiandroid.data.LoginResponse
import com.example.tribiandroid.data.RegisterData
import com.example.tribiandroid.data.RegisterResponse
import com.example.tribiandroid.databinding.ActivityLoginBinding
import com.example.tribiandroid.services.ApiConfig
import com.example.tribiandroid.services.ApiService
import com.example.tribiandroid.ui.MainActivity
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {
            Toast.makeText(this@LoginActivity, "Mencoba untuk masuk",Toast.LENGTH_SHORT).show()
            Login()
        }
    }

    private fun Login(){
        val authPassword = binding.etPassword.text.toString()
        val authEmail = binding.etEmailAddress.text.toString()

        val request = LoginData()
        request.password = authPassword
        request.email = authEmail

        val retrofit = ApiConfig().getRetrofitClientInstance().create(ApiService::class.java)
        retrofit.login(request).enqueue(object : retrofit2.Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val user = response.body()
                if (user != null){
                    Log.e("onResponse: berhasil", user.message.toString())
                    Toast.makeText(this@LoginActivity, "Berhasil untuk masuk",Toast.LENGTH_SHORT).show()
                    Intent(this@LoginActivity, MainActivity::class.java).also {
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "E-mail atau Password yang anda masukkan salah",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            }

        })
    }

}