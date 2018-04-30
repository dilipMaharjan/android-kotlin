package com.kotlin.android.androidkotlin.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.*
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import com.kotlin.android.androidkotlin.R
import com.kotlin.android.androidkotlin.kotlin.Authenticate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mLoginBtn.setOnClickListener {
            val email = mEmailTv.text.toString()
            val auth = Authenticate().login(email, mPasswordTv.text.toString())
            if (auth) {
                val intent = Intent(this, DashboardActivity::class.java).apply {
                    putExtra("email", email)
                }
                startActivity(intent)
            }
        }
        animateView(mLoginBtn)
        mEmailTv.animate().apply {
            duration = 1000
            alpha(0.2f)
            start()
        }
    }

    //view animator
    fun animateView(view: View) {
//        animateViewWithCode(view)
//        animateViewWithXml(view)
//        animateValue(view)
        objectAnimator(view)
        //     animationSet(view)
    }


    fun animateViewWithCode(view: View) {
        var alphaAnimation = AlphaAnimation(1f, 0f)
        alphaAnimation.duration = 5000
        view.startAnimation(alphaAnimation)

    }

    fun animateViewWithXml(view: View) {
        val move = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        move.duration = 10000
        view.startAnimation(move)
    }

    fun animateValue(view: View) {
        var animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = 1000
        animator.addUpdateListener {
            view.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
        }
        animator.start()
    }

    fun objectAnimator(view: View) {
        val translateX = PropertyValuesHolder.ofFloat(TRANSLATION_X, 0f, 400f)
        val translateY = PropertyValuesHolder.ofFloat(TRANSLATION_Y, 400f, 0f)
        val scaleX = PropertyValuesHolder.ofFloat(SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(SCALE_Y, 2f)
        var animator = ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY, translateY, translateX)
        animator.duration = 1000
        animator.start()
    }

    fun animationSet(view: View) {
        val animatorSet = AnimatorSet()

        val scaleX = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f)
        val scaleY = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)

        val tranlateX = ObjectAnimator.ofFloat(view, "translationX", 0f, 400f)
        val tranlateY = ObjectAnimator.ofFloat(view, "translationY", 400f, 0f)
        scaleX.duration = 1000
        scaleY.duration = 1000
        tranlateX.duration = 1000
        tranlateY.duration = 1000
        animatorSet.playSequentially(scaleX, tranlateX, scaleY, tranlateY)
        animatorSet.start()

    }

}
