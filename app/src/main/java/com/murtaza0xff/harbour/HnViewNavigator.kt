package com.murtaza0xff.harbour

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.content.withStyledAttributes
import androidx.core.view.plusAssign
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import java.util.Deque
import java.util.LinkedList

@Navigator.Name("hn_view")
class HnViewNavigator(private val container: ViewGroup) : Navigator<HnViewNavigator.Destination>() {

    private val stack: Deque<Pair<Int, Int>> = LinkedList()

    private fun replaceView(layoutId: Int) {
        container.removeAllViews()
        container += LayoutInflater.from(container.context)
            .inflate(layoutId, container, false)
    }

    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Extras?
    ): NavDestination? {
        val layoutId = destination.layoutId
        stack.push(Pair(destination.id, layoutId))
        replaceView(layoutId)
        return destination
    }

    override fun createDestination(): Destination {
        return Destination(this)
    }

    override fun popBackStack(): Boolean = if (stack.isNotEmpty()) {
        stack.pop()
        replaceView(stack.peek().second)
        true
    } else {
        false
    }

    class Destination(navigator: Navigator<out NavDestination>) : NavDestination(navigator) {
        @LayoutRes
        var layoutId: Int = 0

        override fun onInflate(context: Context, attrs: AttributeSet) {
            super.onInflate(context, attrs)
            context.withStyledAttributes(attrs, R.styleable.HnViewNavigator, 0, 0) {
                layoutId = getResourceId(R.styleable.HnViewNavigator_layoutId, 0)
            }
        }
    }
}
