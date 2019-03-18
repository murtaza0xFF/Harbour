package com.murtaza0xff.harbour.firebaseapi.models

data class User(
    val about: String,
    val created: String,
    val delay: Int,
    val id: String,
    val karma: Long,
    val submitted: List<Long>
)
