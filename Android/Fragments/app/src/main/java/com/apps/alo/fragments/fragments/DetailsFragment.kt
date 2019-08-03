package com.apps.alo.fragments.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.apps.alo.fragments.R
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val miVista = inflater!!.inflate(R.layout.fragment_details, container, false)
        // Inflate the layout for this fragment
        return miVista
    }

    fun renderizar(texto: String) {
        textViewDetails.text = texto
    }

}// Required empty public constructor
