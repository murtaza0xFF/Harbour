package com.murtaza0xff.harbour.storylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.R
import com.murtaza0xff.harbour.algolia.AlgoliaService
import com.murtaza0xff.harbour.firebaseapi.models.BestStory
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.murtaza0xff.harbour.user.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import timber.log.Timber
import javax.inject.Inject

class StoryListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Harbour
            .harbourComponent
            .storyListComponentBuilder()
            .build()
            .inject(this)


    }
}