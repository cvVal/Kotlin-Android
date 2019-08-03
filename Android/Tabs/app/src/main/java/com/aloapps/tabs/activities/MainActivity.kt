package com.aloapps.tabs.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.Toast
import com.aloapps.tabs.R
import com.aloapps.tabs.adapter.PageAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText("Tab número 1"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab número 2"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab número 3"))

        val vPager : ViewPager = findViewById(R.id.viewPager)
        val pAdapter = PageAdapter(supportFragmentManager, tabLayout.tabCount)

        vPager.adapter = pAdapter

        vPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {
                Toast.makeText(this@MainActivity, "tabReselected: "+ tab.text, Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                Toast.makeText(this@MainActivity, "tabUnselected: "+ tab.text, Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                val posicion = tab.position
                vPager.currentItem = posicion
                Toast.makeText(this@MainActivity, "tabSelected: "+ tab.text, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
