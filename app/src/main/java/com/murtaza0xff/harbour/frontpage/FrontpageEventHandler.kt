package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.spotify.mobius.Effects.effects
import com.spotify.mobius.Next
import com.spotify.mobius.Next.dispatch
import com.spotify.mobius.Next.next

fun update(model: FrontpageModel, event: FrontpageEvent): Next<FrontpageModel, FrontpageEffect> {
    return when (event) {
        is HnFrontpageItemsRequested -> loadHnFrontpageItems(event.listingMeta)
        is RefreshRequested -> TODO()
        is RefreshComplete -> next(model)
        is HnPostSelected -> TODO()
        is ReadStatusChanged -> TODO()
        is VoteChanged -> TODO()
    }
}

fun loadHnFrontpageItems(
    listingMeta: ListingMeta
): Next<FrontpageModel, FrontpageEffect> {
    return dispatch(effects(LoadItems(listingMeta)))
}
