package com.aloapps.tabs.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.aloapps.tabs.fragments.TabDos
import com.aloapps.tabs.fragments.TabTres
import com.aloapps.tabs.fragments.TabUno

/**
 * Created by sevevaldez on 17/12/17.
 */
class PageAdapter(fm : FragmentManager?, val numTabs:Int) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> return TabUno()
            1 -> return TabDos()
            2 -> return TabTres()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return numTabs
    }
}