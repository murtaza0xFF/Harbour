package com.murtaza0xff.harbour.firebaseapi.injections

import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.murtaza0xff.harbour.firebaseapi.R
import com.murtaza0xff.harbour.firebaseapi.models.BestStory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class StoryModule {

    @Module
    companion object {

        const val STORY_KEY = "STORY"

        @Provides
        @Reusable
        @JvmStatic
        @StringKey(STORY_KEY)
        @IntoMap
        internal fun providesStoryListingMeta() = ListingMeta(
            R.string.story_hn,
            R.drawable.ic_view_headline,
            BestStory()
        )
    }
}