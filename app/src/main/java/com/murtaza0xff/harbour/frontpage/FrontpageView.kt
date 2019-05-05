package com.murtaza0xff.harbour.frontpage

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.murtaza0xff.harbour.Harbour
import com.murtaza0xff.harbour.R
import com.murtaza0xff.harbour.firebaseapi.ListingMeta
import com.murtaza0xff.harbour.firebaseapi.models.TopStory
import com.murtaza0xff.harbour.firebaseapi.network.FirebaseService
import com.spotify.mobius.Connectable
import com.spotify.mobius.Connection
import com.spotify.mobius.MobiusLoop
import com.spotify.mobius.Next
import com.spotify.mobius.Update
import com.spotify.mobius.android.MobiusAndroid
import com.spotify.mobius.functions.Consumer
import com.spotify.mobius.rx2.RxMobius
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class FrontpageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0
) : FrameLayout(context, attrs, defStyleAttrs), FrontpageViewActions, Connectable<FrontpageViewData, FrontpageEvent> {

    private lateinit var controller: MobiusLoop.Controller<FrontpageModel, FrontpageEvent>
    private val textView by lazy { findViewById<TextView>(R.id.textview) }
    @Inject
    lateinit var listingMetaMap: Map<String, ListingMeta>
    @Inject
    lateinit var firebaseService: FirebaseService
    lateinit var listingMeta: ListingMeta

    init {
        Harbour
            .harbourComponent
            .frontPageComponentBuilder()
            .build()
            .inject(this)

        controller = createController(
            createEffectHandler(listingMeta, this, firebaseService)
        )
    }

    private fun createController(
        effectHandler: ObservableTransformer<FrontpageEffect, FrontpageEvent>
    ): MobiusLoop.Controller<FrontpageModel, FrontpageEvent> {
        return MobiusAndroid.controller(
            createLoop(effectHandler),
            FrontpageModel(emptyList(), TopStory())
        )
    }

    private fun createLoop(effectHandler: ObservableTransformer<FrontpageEffect, FrontpageEvent>):
            MobiusLoop.Builder<FrontpageModel, FrontpageEvent, FrontpageEffect> {
        return loopFactory(::update, effectHandler)
    }

    fun setListingType(key: String) {
        listingMeta = listingMetaMap.getValue(key)
        textView.text = context.getString(listingMeta.name)
    }

    override fun connect(output: Consumer<FrontpageEvent>): Connection<FrontpageViewData> {
    }

    private fun <M, E, F> updateWrapper(u: (M, E) -> Next<M, F>): Update<M, E, F> = Update { m: M, e: E -> u(m, e) }

    fun <M, E, F> loopFactory(u: (M, E) -> Next<M, F>, fh: ObservableTransformer<F, E>) =
        RxMobius.loop(updateWrapper(u), fh)
}
