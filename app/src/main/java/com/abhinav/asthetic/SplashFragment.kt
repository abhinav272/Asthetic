package com.abhinav.asthetic

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import com.abhinav.asthetic.base.BaseFragment
import com.abhinav.asthetic.utils.inflate
import kotlinx.android.synthetic.main.layout_splash.*

class SplashFragment : BaseFragment() {

    private lateinit var logo: ImageView
    private lateinit var animateBtn: Button

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.layout_splash)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logo = iv_logo
        animateBtn = btn
        initialSetup()
        animateBtn.setOnClickListener { doAnimation() }
    }

    private fun initialSetup() {


    }

    private fun doAnimation() {
        var animatorRotation = ObjectAnimator.ofFloat(logo, "rotation", 0f, 360f)
        animatorRotation.duration = 3000

        var animatorScaleXUp = ObjectAnimator.ofFloat(logo, "scaleX", 1f, 1.2f)
        var animatorScaleYUp = ObjectAnimator.ofFloat(logo, "scaleY", 1f, 1.2f)
        animatorScaleXUp.duration = 1000
        animatorScaleYUp.duration = 1000

        var animatorScaleXDown = ObjectAnimator.ofFloat(logo, "scaleX", 1.2f, 1f)
        var animatorScaleYDown = ObjectAnimator.ofFloat(logo, "scaleY", 1.2f, 1f)
        animatorScaleXDown.duration = 1000
        animatorScaleYDown.duration = 1000



        var animatorSet = AnimatorSet()

        animatorSet.play(animatorRotation).with(animatorScaleXUp)
        animatorSet.play(animatorScaleXUp).with(animatorScaleYUp)
        animatorSet.play(animatorScaleXDown).with(animatorScaleYDown)
        animatorSet.play(animatorScaleXUp).before(animatorScaleXDown)



        animatorSet.interpolator = AccelerateDecelerateInterpolator()

        animatorSet.start()

    }

}