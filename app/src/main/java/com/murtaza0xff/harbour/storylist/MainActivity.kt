package com.murtaza0xff.harbour.storylist

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.R

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Harbour
            .harbourComponent
            .storyListComponentBuilder()
            .build()
            .inject(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}
