package com.murtaza0xff.harbour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.murtaza0xff.harbour.firebaseapi.injections.AskModule
import com.murtaza0xff.harbour.firebaseapi.injections.JobModule
import com.murtaza0xff.harbour.firebaseapi.injections.ShowModule
import com.murtaza0xff.harbour.firebaseapi.injections.StoryModule
import com.murtaza0xff.harbour.firebaseapi.models.TopStory
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.murtaza0xff.harbour.frontpage.FrontpageView
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val bottomNavigationBar by lazy { findViewById<BottomNavigationView>(R.id.bottom_navigation_view) }
    @Inject
    lateinit var firebaseService: FirebaseService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Harbour
            .harbourComponent
            .inject(this)

        bottomNavigationBar.setOnNavigationItemSelectedListener(this)
        inflateFrontpageView(StoryModule.STORY_KEY)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.stories_hn -> inflateFrontpageView(StoryModule.STORY_KEY)
            R.id.show_hn -> inflateFrontpageView(ShowModule.SHOW_KEY)
            R.id.ask_hn -> inflateFrontpageView(AskModule.ASK_KEY)
            R.id.jobs_hn -> inflateFrontpageView(JobModule.JOB_KEY)
        }
        return true
    }

    private fun inflateFrontpageView(pageKey: String) {
        val frontPageView = LayoutInflater
            .from(this)
            .inflate(
                R.layout.view_frontpage,
                findViewById(R.id.container),
                true
            ) as FrontpageView
        frontPageView.setListingType(pageKey)
    }
}
