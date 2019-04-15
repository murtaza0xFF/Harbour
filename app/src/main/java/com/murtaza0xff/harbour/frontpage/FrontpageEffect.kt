package com.murtaza0xff.harbour.frontpage

sealed class FrontpageEffect
object LoadItems: FrontpageEffect()
data class ShowFeedback(val type: FeedbackType): FrontpageEffect()
data class NavigateToHnPost(val postId: Long): FrontpageEffect()

