package com.murtaza0xff.harbour

import android.app.Application
import com.murtaza0xff.harbour.injections.DaggerHarbourComponent
import com.murtaza0xff.harbour.injections.HarbourComponent
import timber.log.Timber
import timber.log.Timber.DebugTree


class Harbour : Application() {

    companion object {
        lateinit var harbourComponent: HarbourComponent
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
        harbourComponent = DaggerHarbourComponent
            .builder()
            .application(this)
            .build()
    }
}