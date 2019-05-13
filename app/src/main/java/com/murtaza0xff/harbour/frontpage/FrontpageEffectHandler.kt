package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.models.HackerNewsItem
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.spotify.mobius.rx2.RxMobius
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import timber.log.Timber

fun createEffectHandler(view: FrontpageViewActions, remoteSource: FirebaseService):
        ObservableTransformer<FrontpageEffect, FrontpageEvent> {

    return RxMobius.subtypeEffectHandler<FrontpageEffect, FrontpageEvent>()
        .addTransformer(LoadItems::class.java, refreshHandler(remoteSource))
        .build()
}

fun refreshHandler(
    remoteSource: FirebaseService
): ObservableTransformer<LoadItems, FrontpageEvent> {
    return ObservableTransformer {
        it.flatMapSingle { loadItems: LoadItems ->
            with(remoteSource) {
                fetchItemIds(loadItems.listingMeta.sortOption, 1)
                    .flatMap { fetchHnItemFromId(it) }.toList()
            }.flatMap { hackerNewsList: MutableList<HackerNewsItem> ->
                Timber.d(hackerNewsList.toString())
                Single.just(RefreshComplete(hackerNewsList))
            }
        }
    }
}
