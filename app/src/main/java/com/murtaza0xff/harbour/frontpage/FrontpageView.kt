package com.murtaza0xff.harbour.frontpage

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.R
import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import javax.inject.Inject

class FrontpageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0
) : FrameLayout(context, attrs, defStyleAttrs) {

    private val textView by lazy { findViewById<TextView>(R.id.textview) }
    @Inject
    lateinit var listingMetaMap: Map<String, ListingMeta>

    init {
        Harbour
            .harbourComponent
            .frontPageComponentBuilder()
            .build()
            .inject(this)
    }

    fun setListingType(key: String) {
        textView.text = context.getString(listingMetaMap.getValue(key).name)
    }
}