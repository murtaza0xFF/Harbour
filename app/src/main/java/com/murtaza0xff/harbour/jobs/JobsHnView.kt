package com.murtaza0xff.harbour.jobs

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.murtaza0xff.harbour.R
import kotlinx.android.synthetic.main.list_story.view.*

class JobsHnView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.list_story, this, false)
        addView(view)
        textview.text = "Jobs"
    }
}