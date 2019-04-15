package com.murtaza0xff.harbour.firebaseapi.injections

import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.murtaza0xff.harbour.firebaseapi.R
import com.murtaza0xff.harbour.firebaseapi.models.JobStory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class JobModule {

    @Module
    companion object {

        const val JOB_KEY = "JOB"

        @Provides
        @Reusable
        @JvmStatic
        @StringKey(JOB_KEY)
        @IntoMap
        internal fun providesJobListingMeta() = ListingMeta(
            R.string.job_hn,
            R.drawable.ic_work,
            JobStory()
        )
    }
}