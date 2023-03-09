package com.example.tribiandroid.ui.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tribiandroid.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
    }
}