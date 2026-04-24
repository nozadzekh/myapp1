package com.example.khatia2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.khatia2.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.kn_ze_viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.kn_ze_tabLayout)

        viewPager.adapter = ViewPagerAdapter(this)
        
        // გვარი Nozadze იწყება N-ზე (თანხმოვანი), ამიტომ Vertical
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Input"
                    tab.setIcon(android.R.drawable.ic_menu_edit)
                }
                1 -> {
                    tab.text = "Analytics"
                    tab.setIcon(android.R.drawable.ic_menu_compass)
                }
                else -> {
                    tab.text = "Profile"
                    tab.setIcon(android.R.drawable.ic_menu_mylocation)
                }
            }
        }.attach()
    }
}