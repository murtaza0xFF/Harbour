package com.murtaza0xff.harbour.injections

import android.app.Application
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.MainActivity
import com.murtaza0xff.harbour.frontpage.injections.FrontpageComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HarbourModule::class, NetworkModule::class])
interface HarbourComponent {
    fun inject(harbour: Harbour)
    fun inject(activity: MainActivity)
    fun frontPageComponentBuilder(): FrontpageComponent.Builder

    @Component.Builder
    interface Builder {

        fun build(): HarbourComponent
        @BindsInstance
        fun application(application: Application): Builder
    }
}