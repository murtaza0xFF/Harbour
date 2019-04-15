package com.murtaza0xff.harbour.frontpage

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