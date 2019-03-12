package com.murtaza0xff.harbour.firebaseapi.models

import com.google.firebase.database.DataSnapshot

data class HackerNewsItem(
    var id: Long,
    var deleted: Boolean,
    var type: PostType,
    var by: String,
    var time: Long,
    var text: String,
    var dead: Boolean,
    var parent: Long,
    var kids: List<Long>,
    var url: String,
    var score: Int,
    var title: String,
    val parts: List<Long>,
    var descendants: Int
) {
    companion object {

        fun create(dataSnapshot: DataSnapshot): HackerNewsItem {
            return dataSnapshot.getValue(HackerNewsItem::class.java)!!
        }
    }
}