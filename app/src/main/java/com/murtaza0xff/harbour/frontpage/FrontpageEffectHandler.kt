package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.spotify.mobius.rx2.RxMobius
import io.reactivex.Observable
import io.reactivex.ObservableTransformer

fun createEffectHandler(listingMeta: ListingMeta, view: FrontpageViewActions, remoteSource: FirebaseService):
        ObservableTransformer<FrontpageEffect, FrontpageEvent> {

    val rxEffectHandler: ObservableTransformer<FrontpageEffect, FrontpageEvent> =
        RxMobius.subtypeEffectHandler<FrontpageEffect, FrontpageEvent>()
            .addTransformer<LoadItems>(LoadItems::class.java, refreshHandler(listingMeta, remoteSource))
            .build()
    return rxEffectHandler
}

fun refreshHandler(
    listingMeta: ListingMeta,
    remoteSource: FirebaseService
): ObservableTransformer<LoadItems, FrontpageEvent> {
    return ObservableTransformer<LoadItems, FrontpageEvent> {
        with(remoteSource) {
            it.flatMap {
                fetchItemIds(listingMeta.sortOption, 1)
            }
            Observable.just(RefreshComplete(emptyList()))
        }
    }
}
