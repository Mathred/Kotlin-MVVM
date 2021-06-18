package com.example.kotlinmvvm.framework.ui.main.recyclerviews.decorations

import android.graphics.Rect
import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalListDividerItemDecorator(
    private val space: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                left = space
            }
            top = space
            right = space
            bottom = space
        }
    }


}