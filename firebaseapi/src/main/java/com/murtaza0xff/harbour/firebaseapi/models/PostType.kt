package com.murtaza0xff.harbour.firebaseapi.models

sealed class PostType
object Story : PostType()
object Comment : PostType()
object Ask : PostType()
object Job : PostType()
object Poll : PostType()
object PollOpt : PostType()
