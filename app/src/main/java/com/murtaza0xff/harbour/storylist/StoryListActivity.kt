package com.murtaza0xff.harbour.storylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.firebaseapi.models.NewStory
import com.murtaza0xff.harbour.firebaseapi.models.TopStory
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.murtaza0xff.harbour.user.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import timber.log.Timber
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