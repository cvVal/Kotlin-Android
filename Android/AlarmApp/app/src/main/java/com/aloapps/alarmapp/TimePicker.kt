package com.aloapps.alarmapp

import android.app.DialogFragment
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.time_picker.*
import kotlinx.android.synthetic.main.time_picker.view.*

/**
 * Created by sevevaldez on 16/12/17.
 */
class TimePicker : DialogFragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val miVista = inflater!!.inflate(R.layout.time_picker, container, false)

        val btnHecho = miVista.btnHecho

        btnHecho.setOnClickListener {
            val mActivity = activity as MainActivity
            if (Build.VERSION.SDK_INT >= 23) {
                mActivity.setearHora(timePicker.hour, timePicker.minute)
            }else{
                mActivity.setearHora(timePicker.currentHour, timePicker.currentMinute)
            }

            this.dismiss()
        }

        return miVista
    }
}