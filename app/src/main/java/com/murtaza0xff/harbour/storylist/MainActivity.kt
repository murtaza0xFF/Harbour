package com.murtaza0xff.harbour.storylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.R
import com.murtaza0xff.harbour.firebaseapi.models.TopStory
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val bottomNavigator by lazy { findViewById<BottomNavigationView>(R.id.bottom_navigation_view) }

    @Inject
    lateinit var firebaseService: FirebaseService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Harbour
            .harbourComponent
            .storyListComponentBuilder()
            .build()
            .inject(this)

        navController = Navigation.findNavController(container)
        setupWithNavController(bottomNavigator, navController)
        
    }
}
