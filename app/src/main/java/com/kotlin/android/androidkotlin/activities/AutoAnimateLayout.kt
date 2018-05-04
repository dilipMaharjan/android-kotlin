package com.kotlin.android.androidkotlin.activities

import android.animation.AnimatorInflater
import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v4.view.animation.PathInterpolatorCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlin.android.androidkotlin.R
import kotlinx.android.synthetic.main.activity_auto_animate_layout.*

class AutoAnimateLayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_animate_layout)
//        keyFrameAnimation(tv)
//        viewPropertyAnimator(button)
//        drawableAnimation(button)
        pathInterpolator(button)
//            objectAnimatorXml(button)
    }

    fun keyFrameAnimation(view: View) {
        val kf0 = Keyframe.ofFloat(0f, 0f)
        val kf1 = Keyframe.ofFloat(0.5f, 360f)
        val kf2 = Keyframe.ofFloat(1f, 0f)
        val pvh = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2)
        val rotateAnim = ObjectAnimator.ofPropertyValuesHolder(view, pvh)
        rotateAnim.duration = 5000
        rotateAnim.start()

    }

    fun viewPropertyAnimator(view: View) {
        view.animate().rotation(0f).rotation(30f).rotation(60f).rotation(90f).duration = 5000
    }

    fun drawableAnimation(view: View) {
        var animationDrawable = AnimationDrawable()
        view.setBackgroundResource(R.drawable.animation_list)
        view.background as AnimationDrawable
        animationDrawable.start()
    }

    fun pathInterpolator(view: View) {
        val pi = PathInterpolatorCompat.create(0.4f, 0f, 1f, 1f)
        val oa = ObjectAnimator.ofFloat(view, "rotation", 0f, 90f)
        oa.interpolator = pi
        oa.start()
    }

    fun objectAnimatorXml(view: View) {
        val oa = AnimatorInflater.loadAnimator(this, R.animator.morph)
        oa.duration = 1000
        oa.setTarget(view)
        oa.start()
    }
}
