package com.example.tribiandroid.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tribiandroid.R
import com.example.tribiandroid.ui.fragment.HomepageFragment
import com.example.tribiandroid.ui.fragment.SettingsFragment
import com.example.tribiandroid.ui.fragment.TranslateFragment

private const val ARG_PARAM1="param1"
class ViewPagerNavAdapter (supportFragmentManager: FragmentManager):FragmentPagerAdapter(supportFragmentManager){

    private val COUNT = 3
    override fun getCount(): Int {
        return COUNT
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomepageFragment()
            1 -> TranslateFragment()
            2 -> SettingsFragment()
            else -> HomepageFragment()
        }

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab " + (position + 1)
    }

}