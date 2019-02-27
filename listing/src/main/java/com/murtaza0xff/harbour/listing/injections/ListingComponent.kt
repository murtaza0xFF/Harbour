package com.murtaza0xff.harbour.listing.injections

import android.content.Context
import com.murtaza0xff.harbour.listing.ListingActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ListingScope
@Subcomponent(modules = [(ListingModule::class)])
interface ListingComponent {
    fun inject(listingActivity: ListingActivity)

    @Subcomponent.Builder
    interface Builder {

        fun build(): ListingComponent

        @BindsInstance
        fun activity(context: Context): Builder
    }
}