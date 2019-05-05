package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.murtaza0xff.harbour.firebaseapi.models.HackerNewsItem

sealed class FrontpageEvent
data class RefreshRequested(val listingMeta: ListingMeta) : FrontpageEvent()
data class HnFrontpageItemsRequested(val listingMeta: ListingMeta) : FrontpageEvent()
data class RefreshComplete(val hnItems: List<HackerNewsItem>) : FrontpageEvent()
data class HnPostSelected(val postId: Long) : FrontpageEvent()
data class ReadStatusChanged(val postId: Long) : FrontpageEvent()
data class VoteChanged(val postId: Long) : FrontpageEvent()