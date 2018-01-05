package com.abhinav.asthetic.utils

import android.graphics.drawable.Drawable
import com.abhinav.asthetic.Aesthetic


/**
 * Created by abhinav.sharma on 28/12/17.
 */
object ResourceUtil {
    private val context = Aesthetic.instance
    private val theme = Aesthetic.instance.theme

    fun getDrawableById(resId: Int): Drawable = context.resources.getDrawable(resId, theme)

    fun getString(resId: Int): String = context.resources.getString(resId)

}