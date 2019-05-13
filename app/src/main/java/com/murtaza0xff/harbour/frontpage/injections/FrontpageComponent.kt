package com.murtaza0xff.harbour.frontpage.injections

import com.murtaza0xff.harbour.frontpage.FrontpageFragment
import dagger.Subcomponent

@FrontpageScope
@Subcomponent(modules = [FrontpageModule::class])
interface FrontpageComponent {
    fun inject(fragment: FrontpageFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): FrontpageComponent
    }
}
