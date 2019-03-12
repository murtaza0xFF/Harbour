package com.murtaza0xff.harbour.storylist.di

import com.murtaza0xff.harbour.storylist.StoryListActivity
import dagger.Subcomponent

@StoryListScope
@Subcomponent(modules = [StoryListModule::class])
interface StoryListComponent {
    fun inject(storyListActivity: StoryListActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): StoryListComponent
    }
}
