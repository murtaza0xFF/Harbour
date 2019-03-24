package com.murtaza0xff.harbour

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class CustomPagerAdapter(private val context: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val viewPagerModel: ViewPagerModel? = ViewPagerModel.viewPagerModelHashMap[position]
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(viewPagerModel.viewPagerLayoutResId, container, false) as ViewGroup
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeViewAt(position)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return ViewPagerModel.viewPagerModelHashMap.size
    }
}