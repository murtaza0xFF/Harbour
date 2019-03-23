package com.murtaza0xff.harbour.firebaseapi.models

sealed class SealedStory(val route: String)
class NewStory : SealedStory("v0/newstories")
class TopStory : SealedStory("v0/topstories")
class BestStory : SealedStory("v0/beststories")
class AskStory: SealedStory("v0/askstories")
class ShowStory: SealedStory("v0/showstories")
class JobStory: SealedStory("v0/jobstories")


