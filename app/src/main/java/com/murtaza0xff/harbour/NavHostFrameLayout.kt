package com.murtaza0xff.harbour

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation

class NavHostFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), NavHost {

    private val navController = NavController(context)

    init {
        Navigation.setViewNavController(this, navController)
        val hnViewNavigator = HnViewNavigator(this)
        navController.navigatorProvider.addNavigator(hnViewNavigator)
        context.withStyledAttributes(attrs, R.styleable.NavHostFrame, 0, 0) {
            val graphId = getResourceId(R.styleable.NavHostFrame_navGraph, 0)
            navController.setGraph(graphId)
        }
    }

    override fun getNavController() = navController

    override fun onSaveInstanceState(): Parcelable {
        return Bundle().apply {
            putParcelable(KEY_VIEW_STATE, super.onSaveInstanceState())
            putParcelable(KET_NAV_CONTROLLER_STATE, navController.saveState())
        }
    }

    override fun onRestoreInstanceState(state: Parcelable) {
        if (state is Bundle && state.containsKey(KEY_VIEW_STATE)) {
            super.onRestoreInstanceState(state.getParcelable(KEY_VIEW_STATE))
            navController.restoreState(state.getParcelable(KET_NAV_CONTROLLER_STATE))
        } else {
            super.onRestoreInstanceState(state)
        }
    }

    companion object {
        const val KEY_VIEW_STATE = "viewState"
        const val KET_NAV_CONTROLLER_STATE = "navControllerState"
    }
}
