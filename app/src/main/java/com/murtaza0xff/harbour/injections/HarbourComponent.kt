package com.murtaza0xff.harbour.injections

import android.app.Application
import com.murtaza0xff.harbour.Harbour
import dagger.BindsInstance
import dagger.Component

@Component(modules = [HarbourModule::class])
interface HarbourComponent {
    fun inject(harbour: Harbour)

    @Component.Builder
    interface Builder {

        fun build(): Harbour
        @BindsInstance
        fun application(application: Application): Builder
    }
}