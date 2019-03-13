package com.murtaza0xff.harbour.storylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.firebaseapi.models.NewStory
import com.murtaza0xff.harbour.firebaseapi.models.TopStory
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class StoryListActivity : AppCompatActivity() {

    @Inject
    lateinit var firebaseService: FirebaseService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Harbour
            .harbourComponent
            .storyListComponentBuilder()
            .build()
            .inject(this)

        firebaseService
            .fetchItem(TopStory(), 0, 10)
            .doOnNext {
                Timber.d("HN Post: $it")
            }
            .filter {
                it.kids != null
            }
            .map {
                it.kids
            }
            .flatMap {
                firebaseService.fetchChildren(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Timber.d("Comment: $it")
            }
    }
}