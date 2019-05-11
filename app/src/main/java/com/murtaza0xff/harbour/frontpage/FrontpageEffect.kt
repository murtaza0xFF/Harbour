package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.models.HackerNewsItem

sealed class FrontpageEffect
object LoadItems : FrontpageEffect()
data class ItemsLoaded(val items: List<HackerNewsItem>)
data class ShowFeedback(val type: FeedbackType) : FrontpageEffect()
data class NavigateToHnPost(val postId: Long) : FrontpageEffect()
