package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.ListingMeta

sealed class FrontpageEffect
data class LoadItems(val listingMeta: ListingMeta) : FrontpageEffect()
data class ShowFeedback(val type: FeedbackType) : FrontpageEffect()
data class NavigateToHnPost(val postId: Long) : FrontpageEffect()
