package com.example.tribiandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.tribiandroid.R
import com.example.tribiandroid.databinding.ActivityMainBinding
import com.example.tribiandroid.ui.adapter.ViewPagerNavAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.bottomNavView.setOnItemSelectedListener { id ->
            when(id){
                R.id.homepage -> binding.viewPagerNav.currentItem = 0
                R.id.translate -> binding.viewPagerNav.currentItem = 1
                R.id.settings -> binding.viewPagerNav.currentItem = 2
            }
        }

        binding.viewPagerNav.setOnTouchListener(View.OnTouchListener { v, event -> true })
        binding.viewPagerNav.adapter = ViewPagerNavAdapter(supportFragmentManager)
    }
}