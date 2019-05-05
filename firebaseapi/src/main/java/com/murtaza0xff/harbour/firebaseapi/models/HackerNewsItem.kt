package com.murtaza0xff.harbour.firebaseapi.models

import androidx.annotation.Keep
import com.google.firebase.database.DataSnapshot
import com.murtaza0xff.harbour.firebaseapi.NoArg

@Keep
@NoArg
data class HackerNewsItem(
    var id: Long,
    var deleted: Boolean,
    var type: String,
    var by: String,
    var time: Long,
    var text: String?,
    var dead: Boolean,
    var parent: Long,
    var kids: List<Long>?,
    var url: String,
    var score: Int,
    var title: String,
    val parts: List<Long>?,
    var descendants: Int
) {
    companion object {

        fun create(dataSnapshot: DataSnapshot): HackerNewsItem {
            return dataSnapshot.getValue(HackerNewsItem::class.java)!!
        }
    }

    override fun toString(): String {
        return "HackerNewsItem(id=$id, deleted=$deleted, type='$type', by='$by', time=$time, text=$text, dead=$dead, parent=$parent, kids=$kids, url='$url', score=$score, title='$title', parts=$parts, descendants=$descendants)"
    }
}