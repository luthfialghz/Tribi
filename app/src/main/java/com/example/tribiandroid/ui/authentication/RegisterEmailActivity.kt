package com.example.tribiandroid.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tribiandroid.databinding.ActivityRegisterEmailBinding
import com.example.tribiandroid.ui.MainActivity

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
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}