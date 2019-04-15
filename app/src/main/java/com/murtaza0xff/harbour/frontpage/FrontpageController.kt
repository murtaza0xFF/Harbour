package com.murtaza0xff.harbour.frontpage

import com.spotify.mobius.rx2.RxMobius

class FrontpageController<F, E>{

    val builder: RxMobius.SubtypeEffectHandlerBuilder<F, E> = RxMobius.subtypeEffectHandler()

    var rxEffectHandler = RxMobius.subtypeEffectHandler<F, E>()
        .addTransformer<RefreshList>(refreshHandler())
}