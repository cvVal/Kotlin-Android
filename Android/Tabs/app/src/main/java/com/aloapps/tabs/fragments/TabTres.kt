package com.aloapps.tabs.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.aloapps.tabs.R


/**
 * A simple [Fragment] subclass.
 */
class TabTres : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_tab_tres, container, false)
    }

}// Required empty public constructor
