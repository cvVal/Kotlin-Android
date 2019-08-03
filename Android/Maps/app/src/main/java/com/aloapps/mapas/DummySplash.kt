package com.aloapps.mapas

import android.app.Application
import android.os.SystemClock

/**
 * Created by sevevaldez on 18/03/18.
 */
class DummySplash: Application() {

    override fun onCreate() {
        super.onCreate()

        SystemClock.sleep(3000)
    }
}