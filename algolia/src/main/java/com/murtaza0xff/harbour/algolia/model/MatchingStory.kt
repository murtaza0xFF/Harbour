package com.murtaza0xff.harbour.algolia.model

data class MatchingStory(
    val exhaustiveNbHits: Boolean,
    val hits: List<StoryHit>,
    val hitsPerPage: Int,
    val nbHits: Int,
    val nbPages: Int,
    val page: Int,
    val params: String,
    val processingTimeMS: Int,
    val query: String
)

