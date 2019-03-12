package com.murtaza0xff.harbour.firebaseapi.models

sealed class SealedStory(val route: String)
class NewStory : SealedStory("v0/newstories")
class TopStory : SealedStory("v0/topstories")
class BestStory : SealedStory("v0/beststories")


