package com.murtaza0xff.harbour.firebaseapi.injections

import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.murtaza0xff.harbour.firebaseapi.R
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class AskModule {

    @Module
    companion object {

        const val ASK_KEY = "ASK"

        @Provides
        @Reusable
        @JvmStatic
        @StringKey(ASK_KEY)
        @IntoMap
        internal fun providesAskListingMeta() = ListingMeta(
            R.string.ask_hn,
            R.drawable.ic_question_answer
        )
    }
}