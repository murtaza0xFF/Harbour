package com.murtaza0xff.harbour.firebaseapi

sealed class SealedStory(val route: String) {
    class NewStory : SealedStory("v0/newstories")
    class TopStory : SealedStory("v0/topstories")
    class BestStory : SealedStory("v0/beststories")

    companion object {
        val map = hashMapOf(
            0 to NewStory(),
            1 to TopStory(),
            2 to BestStory()
        )
    }

}