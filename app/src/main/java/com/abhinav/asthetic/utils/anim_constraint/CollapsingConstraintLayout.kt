package com.abhinav.asthetic.utils.anim_constraint

import android.animation.ObjectAnimator
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.design.widget.AppBarLayout
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.abhinav.asthetic.R

class CollapsingConstraintLayout : ConstraintLayout, AppBarLayout.OnOffsetChangedListener {


    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    private var mTransitionThreshold = 0.35f
    private var mLastPosition: Int = 0
    private var mToolbarOpen = true

    private val mOpenToolbarSet = ConstraintSet()
    private val mClosedToolbarSet = ConstraintSet()


    class AnimationHelper(view: View) {
        var initialValue = 0
        var target = view

        init {
            initialValue = target.left
        }

        fun evaluate() {
            if (initialValue != target.left) {
                var delta = (initialValue - target.left).toFloat()
                val anim = ObjectAnimator.ofFloat(target, "translationX", delta, 0f)
                anim.duration = 400
                anim.start()
                initialValue = target.left
            }
        }
    }


    private lateinit var mTitle: TextView
    private lateinit var mImage: ImageView
    private lateinit var mBackground: ImageView
    private var mTranslationTitle: AnimationHelper? = null
    private var mTranslationIcon: AnimationHelper? = null
    private lateinit var showBackgroundAnimator: ObjectAnimator
    private lateinit var hideBackgroundAnimator: ObjectAnimator

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (parent is AppBarLayout) {
            val appBarLayout = parent as AppBarLayout
            appBarLayout.addOnOffsetChangedListener(this)
            mOpenToolbarSet.clone(context, R.layout.constraint_layout_project_detail_open_sample)
            mClosedToolbarSet.clone(context, R.layout.constraint_layout_project_detail_closed_sample)

            mTitle = findViewById(R.id.tv_name)
            mImage = findViewById(R.id.iv_image)
            mBackground = findViewById(R.id.iv_background)
            mTitle.tag = "title"
            mImage.tag = "image"

            showBackgroundAnimator = ObjectAnimator.ofFloat(mBackground, "alpha", 0f, 1f)
            hideBackgroundAnimator = ObjectAnimator.ofFloat(mBackground, "alpha", 1f, 0f)

            showBackgroundAnimator.duration = 600
            hideBackgroundAnimator.duration = 600

        }
    }


    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (mLastPosition == verticalOffset)
            return

        mLastPosition = verticalOffset
        val progress = Math.abs(verticalOffset / (appBarLayout?.height?.toFloat()!!))
        val layoutParams = layoutParams as AppBarLayout.LayoutParams
        layoutParams.topMargin = -verticalOffset
        setLayoutParams(layoutParams)

        if (mToolbarOpen && progress > mTransitionThreshold) {
            mClosedToolbarSet.applyTo(this)
            mToolbarOpen = false
            hideBackgroundAnimator.start()
        } else if (!mToolbarOpen && progress < mTransitionThreshold) {
            mOpenToolbarSet.applyTo(this)
            mToolbarOpen = true
            showBackgroundAnimator.start()
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (mTranslationTitle == null) {
            mTranslationTitle = AnimationHelper(mTitle)
        }

        if (mTranslationIcon == null) {
            mTranslationIcon = AnimationHelper(mImage)
        }

        mTranslationTitle!!.evaluate()
        mTranslationIcon!!.evaluate()
    }

}