package com.aloapps.navigationdrawer.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aloapps.navigationdrawer.R


/**
 * A simple [Fragment] subclass.
 */
 class PerfilFragment:Fragment() {


public override fun onCreateView(inflater:LayoutInflater?, container:ViewGroup?,
savedInstanceState:Bundle?):View? {
 // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_perfil, container, false)
}

}// Required empty public constructor
