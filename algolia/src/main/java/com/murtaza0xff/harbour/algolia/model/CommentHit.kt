package com.murtaza0xff.harbour.algolia.model

data class CommentHit(
    val author: String,
    val comment_text: String,
    val created_at_i: Int,
    val objectID: String,
    val story_id: Int,
    val story_title: String,
    val story_url: String
)