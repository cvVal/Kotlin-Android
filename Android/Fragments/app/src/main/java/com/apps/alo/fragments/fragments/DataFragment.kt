package com.apps.alo.fragments.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.apps.alo.fragments.R
import kotlinx.android.synthetic.main.fragment_data.view.*

class DataFragment : Fragment() {

    var llamada : DataLister? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try {
            llamada = context as DataLister
        }catch (e: Exception){}
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val miVista = inflater!!.inflate(R.layout.fragment_data, container, false)
        val editTxt = miVista.editTextData
        val btnEnviar = miVista.btnEnviar

        btnEnviar.setOnClickListener {
            val texto = editTxt.text.toString()
            llamada!!.enviarDatos(texto)
        }

        // Inflate the layout for this fragment
        return miVista
    }

    interface DataLister{
        fun enviarDatos(text: String)
    }

}// Required empty public constructor
