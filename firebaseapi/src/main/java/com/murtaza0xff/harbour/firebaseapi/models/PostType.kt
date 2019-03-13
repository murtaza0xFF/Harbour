package com.murtaza0xff.harbour.firebaseapi.models

import androidx.annotation.Keep

@Keep
sealed class PostType(val type: String)
object Story : PostType("story")
object Comment : PostType("comment")
object Ask : PostType("ask")
object Job : PostType("job")
object Poll : PostType("poll")
object PollOpt : PostType("pollopt")
