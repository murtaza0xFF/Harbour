package com.murtaza0xff.harbour.injections

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class HarbourModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun sharedPreferences(application: Application): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(application)
        }
    }
}