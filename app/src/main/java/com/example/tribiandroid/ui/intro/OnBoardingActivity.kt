package com.example.tribiandroid.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.tribiandroid.R
import com.example.tribiandroid.adapter.IntroSliderAdapter
import com.example.tribiandroid.data.IntroSlide
import com.example.tribiandroid.databinding.ActivityOnBoardingBinding
import com.example.tribiandroid.ui.authentication.RegisterActivity

class OnBoardingActivity : AppCompatActivity() {


    private lateinit var binding: ActivityOnBoardingBinding
    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Terjemahkan SIBI",
                "Membantu memahami Sistem Isyarat Bahasa Indonesia (SIBI) untuk berkomunikasi dengan teman tuli lebih efisien",
                R.drawable.banner_one
            ),
            IntroSlide(
                "Sederhana",
                "Kami memberikan pengalaman yang sederhana dan mudah digunakan untuk menerjemahkan bahasa isyarat.",
                R.drawable.banner_two
            ),
            IntroSlide(
                "Inklusif",
                "Aplikasi kami dirancang untuk memastikan inklusivitas dalam komunikasi dan membantu orang yang menggunakan bahasa isyarat untuk berkomunikasi lebih mudah dengan orang lain.",
                R.drawable.banner_three
            ),
            IntroSlide(
                "Inovatif",
                "Kami mengadopsi teknologi terbaru untuk memberikan solusi yang inovatif bagi orang yang menggunakan bahasa isyarat, dan mendukung kemajuan sosial melalui teknologi.",
                R.drawable.banner_four
            ),
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.introSliderViewPager.adapter = introSliderAdapter

        supportActionBar?.hide()
        setupIndicators()
        setCurrentIndicator(0)
        binding.introSliderViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        binding.btnNext.setOnClickListener {
            if(binding.introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount){
                binding.introSliderViewPager.currentItem += 1
            } else {
                Intent(applicationContext, RegisterActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.indicatorContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int){
        val childCount = binding.indicatorContainer.childCount
        for (i in 0 until childCount){
            val imageView = binding.indicatorContainer[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}