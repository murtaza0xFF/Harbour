package com.murtaza0xff.harbour.algolia.model

data class UrlHit(
    val author: String,
    val comment_text: Any,
    val created_at_i: Int,
    val num_comments: Int,
    val objectID: String,
    val points: Int,
    val story_text: String,
    val title: String,
    val url: String
)