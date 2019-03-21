package com.murtaza0xff.harbour.algolia.model

import com.squareup.moshi.Json

sealed class SearchItem
data class MatchingComment(
    @field:Json(name = "hits") val hits: List<Hit>
) : SearchItem()

data class MatchingStory(
    @field:Json(name = "hits") val hits: List<Hit>
) : SearchItem()

data class MatchingUrl(
    @field:Json(name = "hits") val hits: List<Hit>
) : SearchItem()