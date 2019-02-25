package com.murtaza0xff.harbour.injections

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class HarbourModule {

    @Binds
    @Singleton
    fun sharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }
}