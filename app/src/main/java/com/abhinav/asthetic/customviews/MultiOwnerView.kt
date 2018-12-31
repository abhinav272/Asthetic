package com.abhinav.asthetic.customviews

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import com.abhinav.asthetic.R

class MultiOwnerView : RecyclerView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    init {
        View.inflate(context, R.layout.layout_recycler_view, this)
    }



}