package com.murtaza0xff.harbour.frontpage

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.R
import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.spotify.mobius.Connectable
import com.spotify.mobius.Connection
import com.spotify.mobius.MobiusLoop
import com.spotify.mobius.android.MobiusAndroid
import com.spotify.mobius.functions.Consumer
import javax.inject.Inject

class FrontpageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0
) : FrameLayout(context, attrs, defStyleAttrs), Connectable<FrontpageViewData, FrontpageEvent> {

    private lateinit var controller: MobiusLoop.Controller<FrontpageModel, FrontpageEvent>
    private val textView by lazy { findViewById<TextView>(R.id.textview) }
    @Inject
    lateinit var listingMetaMap: Map<String, ListingMeta>

    init {
        Harbour
            .harbourComponent
            .frontPageComponentBuilder()
            .build()
            .inject(this)

        controller = createController(
            createEffectHandler(context!!, mViews, this::showAddTask, this::showTaskDetailsUi),
            mEventSource,
            resolveDefaultModel(savedInstanceState))

    }

    private fun createController(
        createEffectHandler: Any,
        mEventSource: Any,
        resolveDefaultModel: Any
    ): MobiusLoop.Controller<FrontpageModel, FrontpageEvent> {
        MobiusAndroid.controller(createLoop())
    }

    fun setListingType(key: String) {
        textView.text = context.getString(listingMetaMap.getValue(key).name)
    }

    override fun connect(output: Consumer<FrontpageEvent>): Connection<FrontpageViewData> {

    }
}
