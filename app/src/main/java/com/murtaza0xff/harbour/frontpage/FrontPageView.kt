package com.murtaza0xff.harbour.frontpage

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.R
import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import kotlinx.android.synthetic.main.list_story.view.*
import javax.inject.Inject

class FrontPageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttrs) {

    val textView by lazy { findViewById<TextView>(R.id.textview) }
    @Inject
    lateinit var listingMetaMap: Map<String, ListingMeta>

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.list_story, this, false)
        addView(view)
        Harbour
            .harbourComponent
            .frontPageComponentBuilder()
            .build()
            .inject(this)
        textView.text = listingMetaMap["ASK"]?.name.toString()
    }
}