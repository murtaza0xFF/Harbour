package com.murtaza0xff.harbour

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.murtaza0xff.harbour.firebaseapi.injections.StoryModule
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val bottomNavigationBar by lazy { findViewById<BottomNavigationView>(R.id.bottom_navigation_view) }
    val navController by lazy { findNavController(R.id.fragment_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Harbour
            .harbourComponent
            .inject(this)
        val args = Bundle()
        args.putString("listing_type", StoryModule.STORY_KEY)
        navController.setGraph(R.navigation.navigation_frontpage, args)
        bottomNavigationBar.setupWithNavController(navController)
    }
}
