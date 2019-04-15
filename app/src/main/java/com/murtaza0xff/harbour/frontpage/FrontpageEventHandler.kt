package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.spotify.mobius.rx2.RxMobius
import io.reactivex.ObservableTransformer

fun createHandler(listingMeta: ListingMeta, view: FrontpageViewActions, remoteSource: FirebaseService) {

    val rxEffectHandler: ObservableTransformer<FrontpageEffect, FrontpageEvent> =
        RxMobius.subtypeEffectHandler<FrontpageEffect, FrontpageEvent>()
            .addTransformer<LoadItems>(LoadItems::class.java, refreshHandler(listingMeta, remoteSource))
            .build()
}

fun refreshHandler(
    listingMeta: ListingMeta,
    remoteSource: FirebaseService
): ObservableTransformer<LoadItems, FrontpageEvent> {
    ObservableTransformer<LoadItems, FrontpageEvent> {
        it.flatMap {
            remoteSource
                .fetchItemIds(listingMeta.sortOption, 1, 25L)
                .toObservable()

        }

    }
}
