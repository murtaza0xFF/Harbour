package com.murtaza0xff.harbour.algolia.model

import com.squareup.moshi.Json

data class Hit(
    @field:Json(name = "author") val author: String?,
    @field:Json(name = "comment_text") val commentText: String?,
    @field:Json(name = "created_at_i") val createdAt: Int?,
    @field:Json(name = "objectID") val objectId: String?,
    @field:Json(name = "story_id") val storyId: Int?,
    @field:Json(name = "story_title") val storyTitle: String?,
    @field:Json(name = "story_url") val storyUrl: String?,
    @field:Json(name = "num_comments") val numComments: Int?,
    @field:Json(name = "points") val points: Int?,
    @field:Json(name = "story_text") val storyText: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "url") val url: String?
)