package com.vicky7230.cayennekt.ui.home.recipes

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View


/**
 * Created by vicky on 1/1/18.
 */
class ItemOffsetDecoration(private val offset: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = offset / 2
        outRect.bottom = offset / 2
    }

}