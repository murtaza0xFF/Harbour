package com.murtaza0xff.harbour.frontpage

import com.murtaza0xff.harbour.firebaseapi.models.HackerNewsItem
import com.murtaza0xff.harbour.firebaseapi.models.SortOptions

data class FrontpageModel(
    val hnItems: List<HackerNewsItem>,
    val sortType: SortOptions
)
