package com.murtaza0xff.harbour.storylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val bottomNavigator by lazy { findViewById<BottomNavigationView>(R.id.bottom_navigation_view) }

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
