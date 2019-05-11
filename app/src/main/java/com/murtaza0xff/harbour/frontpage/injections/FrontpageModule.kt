package com.murtaza0xff.harbour.frontpage.injections

import com.murtaza0xff.harbour.firebaseapi.injections.AskModule
import com.murtaza0xff.harbour.firebaseapi.injections.JobModule
import com.murtaza0xff.harbour.firebaseapi.injections.ShowModule
import com.murtaza0xff.harbour.firebaseapi.injections.StoryModule
import com.murtaza0xff.harbour.frontpage.FrontpageRepository
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        AskModule::class,
        JobModule::class,
        ShowModule::class,
        StoryModule::class
    ]
)
class FrontpageModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @FrontpageScope
        fun frontpageRepository(): FrontpageRepository {
            return FrontpageRepository()
        }
    }
}
