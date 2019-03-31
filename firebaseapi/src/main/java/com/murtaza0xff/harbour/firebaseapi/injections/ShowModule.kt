package com.murtaza0xff.harbour.firebaseapi.injections

import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.murtaza0xff.harbour.firebaseapi.R
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ShowModule {

    @Module
    companion object {

        const val SHOW_KEY = "SHOW"

        @Provides
        @Reusable
        @JvmStatic
        @StringKey(SHOW_KEY)
        @IntoMap
        internal fun providesShowListingMeta() = ListingMeta(
            R.string.show_hn,
            R.drawable.ic_computer
        )
    }
}