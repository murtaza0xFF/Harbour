package com.murtaza0xff.harbour.storylist.injections

import com.murtaza0xff.harbour.storylist.MainActivity
import dagger.Subcomponent

@StoryListScope
@Subcomponent(modules = [StoryListModule::class])
interface StoryListComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): StoryListComponent
    }
}
