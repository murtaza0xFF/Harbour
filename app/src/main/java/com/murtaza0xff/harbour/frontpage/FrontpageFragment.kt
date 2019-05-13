package com.murtaza0xff.harbour.frontpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.murtaza0xff.harbour.Harbour
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
import kotlinx.android.synthetic.main.fragment_frontpage.*
import timber.log.Timber
import javax.inject.Inject

class FrontpageFragment : Fragment(), FrontpageViewActions, Connectable<FrontpageModel, FrontpageEvent> {


    private lateinit var controller: MobiusLoop.Controller<FrontpageModel, FrontpageEvent>
    @Inject
    lateinit var listingMetaMap: Map<String, ListingMeta>
    @Inject
    lateinit var firebaseService: FirebaseService
    lateinit var listingMeta: ListingMeta
    val args: FrontpageFragmentArgs by navArgs()

    init {
        Harbour
            .harbourComponent
            .frontPageComponentBuilder()
            .build()
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(com.murtaza0xff.harbour.R.layout.fragment_frontpage, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setListingType(args.listingType)
        controller = createController(createEffectHandler(this, firebaseService))
        controller.connect(this)
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

    private fun setListingType(key: String) {
        listingMeta = listingMetaMap.getValue(key)
        textview.text = context?.getString(listingMeta.name)
    }

    override fun connect(output: Consumer<FrontpageEvent>): Connection<FrontpageModel> {
        textview.setOnClickListener {
            output.accept(HnFrontpageItemsRequested(listingMeta))
        }
        return object : Connection<FrontpageModel> {
            override fun accept(value: FrontpageModel) {
                Timber.d(value.hnItems.toString())
                textview.text = value.hnItems.toString()
            }

            override fun dispose() {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        controller.disconnect()
    }

    override fun onResume() {
        super.onResume()
        controller.start()
    }

    override fun onPause() {
        super.onPause()
        controller.stop()
    }

    private fun <M, E, F> updateWrapper(u: (M, E) -> Next<M, F>): Update<M, E, F> = Update { m: M, e: E -> u(m, e) }

    fun <M, E, F> loopFactory(u: (M, E) -> Next<M, F>, fh: ObservableTransformer<F, E>) =
        RxMobius.loop(updateWrapper(u), fh)
}
