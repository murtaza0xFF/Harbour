package com.murtaza0xff.harbour

import androidx.annotation.LayoutRes

sealed class ViewPagerModel(val viewPagerTitle: String, @LayoutRes val viewPagerLayoutResId: Int) {
    data class StoriesHn(val title: String, @LayoutRes val layoutResId: Int) : ViewPagerModel(title, layoutResId)
    data class ShowHn(val title: String, @LayoutRes val layoutResId: Int) : ViewPagerModel(title, layoutResId)
    data class AskHn(val title: String, @LayoutRes val layoutResId: Int) : ViewPagerModel(title, layoutResId)
    data class JobsHn(val title: String, @LayoutRes val layoutResId: Int) : ViewPagerModel(title, layoutResId)

    companion object {
        val viewPagerModelHashMap = hashMapOf(
            0 to StoriesHn("Stories", R.layout.view_stories),
            1 to ShowHn("Show HN", R.layout.view_show),
            2 to AskHn("Ask HN", R.layout.view_ask),
            3 to JobsHn("Jobs HN", R.layout.view_jobs)
        )
    }
}