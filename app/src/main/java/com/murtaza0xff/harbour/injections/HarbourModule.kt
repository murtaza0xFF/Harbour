package com.murtaza0xff.harbour.injections

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.firebase.database.FirebaseDatabase
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.murtaza0xff.harbour.user.UserService
import com.squareup.moshi.Moshi
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

        @JvmStatic
        @Provides
        @Singleton
        fun providesMoshi(): Moshi {
            return Moshi
                .Builder()
                .build()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun providesFirebaseDatabase(): FirebaseDatabase {
            return FirebaseDatabase.getInstance()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun providesFirebaseService(firebaseDatabase: FirebaseDatabase): FirebaseService {
            return FirebaseService(firebaseDatabase)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideUserService(): UserService {
            return UserService()
        }
    }
}