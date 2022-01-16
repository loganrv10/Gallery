package com.shubham.gallery.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.shubham.gallery.R
import com.shubham.gallery.ui.adapter.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FragmentAdapter
    private lateinit var viewPager : ViewPager2
    private lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Images"
                }
                1 -> {
                    tab.text = "Videos"
                }
            }
        }.attach()
    }
}