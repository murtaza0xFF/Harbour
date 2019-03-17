package com.murtaza0xff.harbour.storylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.murtaza0xff.harbour.user.UserService
import okhttp3.OkHttpClient
import javax.inject.Inject

class StoryListActivity : AppCompatActivity() {

    @Inject
    lateinit var firebaseService: FirebaseService

    @Inject
    lateinit var userService: UserService

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Harbour
            .harbourComponent
            .storyListComponentBuilder()
            .build()
            .inject(this)

    }
}