package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.injections.AskModule
import com.murtaza0xff.harbour.firebaseapi.injections.JobModule
import com.murtaza0xff.harbour.firebaseapi.injections.ShowModule
import com.murtaza0xff.harbour.firebaseapi.injections.StoryModule
import dagger.Module

@Module(
    includes = [
        AskModule::class,
        JobModule::class,
        ShowModule::class,
        StoryModule::class
    ]
)
class FrontpageModule
