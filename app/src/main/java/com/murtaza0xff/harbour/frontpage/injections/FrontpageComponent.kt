package com.murtaza0xff.harbour.frontpage.injections

import com.murtaza0xff.harbour.frontpage.FrontpageView
import dagger.Subcomponent

@FrontpageScope
@Subcomponent(modules = [FrontpageModule::class])
interface FrontpageComponent {
    fun inject(view: FrontpageView)

    @Subcomponent.Builder
    interface Builder {
        fun build(): FrontpageComponent
    }
}
