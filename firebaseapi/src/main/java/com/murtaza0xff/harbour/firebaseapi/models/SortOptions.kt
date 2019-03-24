package com.murtaza0xff.harbour.firebaseapi.models

sealed class SortOptions(val route: String)
class NewStory : SortOptions("v0/newstories")
class TopStory : SortOptions("v0/topstories")
class BestStory : SortOptions("v0/beststories")
class AskStory: SortOptions("v0/askstories")
class ShowStory: SortOptions("v0/showstories")
class JobStory: SortOptions("v0/jobstories")


