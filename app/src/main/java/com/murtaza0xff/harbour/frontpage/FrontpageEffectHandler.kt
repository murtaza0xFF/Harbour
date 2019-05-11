package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.spotify.mobius.rx2.RxMobius
import io.reactivex.ObservableTransformer
import io.reactivex.Single

fun createEffectHandler(listingMeta: ListingMeta, view: FrontpageViewActions, remoteSource: FirebaseService):
        ObservableTransformer<FrontpageEffect, FrontpageEvent> {

    return RxMobius.subtypeEffectHandler<FrontpageEffect, FrontpageEvent>()
        .addTransformer(LoadItems::class.java, refreshHandler(listingMeta, remoteSource))
        .build()
}

fun refreshHandler(
    listingMeta: ListingMeta,
    remoteSource: FirebaseService
): ObservableTransformer<LoadItems, FrontpageEvent> {
    return ObservableTransformer {
        it.flatMapSingle {
            with(remoteSource) {
                fetchItemIds(listingMeta.sortOption, 1)
                    .flatMap { fetchHnItemFromId(it) }
                    .toList()
            }.flatMap {
                Single.just(RefreshComplete(it))
            }
        }
    }
}




