package com.apps.alo.fragments.activities

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.apps.alo.fragments.R
import com.apps.alo.fragments.fragments.DataFragment
import com.apps.alo.fragments.fragments.DetailsFragment

class MainActivity : FragmentActivity(), DataFragment.DataLister {
    override fun enviarDatos(text: String) {

        val dFragment = supportFragmentManager.findFragmentById(R.id.detailsFragment) as DetailsFragment
        dFragment.renderizar(text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
