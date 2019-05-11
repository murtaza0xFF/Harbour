package com.murtaza0xff.harbour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.murtaza0xff.harbour.firebaseapi.injections.AskModule
import com.murtaza0xff.harbour.firebaseapi.injections.JobModule
import com.murtaza0xff.harbour.firebaseapi.injections.ShowModule
import com.murtaza0xff.harbour.firebaseapi.injections.StoryModule
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.murtaza0xff.harbour.frontpage.FrontpageView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val bottomNavigationBar by lazy { findViewById<BottomNavigationView>(R.id.bottom_navigation_view) }
    @Inject
    lateinit var firebaseService: FirebaseService
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Harbour
            .harbourComponent
            .inject(this)

        navController = Navigation.findNavController(frontpage_container)

        bottomNavigationBar.setOnNavigationItemSelectedListener(this)
        Navigation.setViewNavController(bottom_navigation_view, navController)
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
