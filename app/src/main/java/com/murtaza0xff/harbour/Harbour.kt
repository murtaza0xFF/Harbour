package com.murtaza0xff.harbour

import android.app.Application
import com.murtaza0xff.harbour.injections.HarbourComponent

class Harbour : Application() {

    companion object {
        lateinit var harbourComponent: HarbourComponent
    }
    override fun onCreate() {
        super.onCreate()
//        harbourComponent = DaggerHarbourComponent()
//
//            .application(this)
//            .build()
    }
}