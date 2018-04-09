package com.kotlin.android.androidkotlin.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.kotlin.android.androidkotlin.R
import kotlinx.android.synthetic.main.activity_dashboard.*
import android.support.animation.SpringAnimation




class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val email = intent.getStringExtra("email")
        findViewById<TextView>(R.id.mWelcomeTv).apply {
            text = email
        }
        val animX = ObjectAnimator.ofFloat(mWelcomeTv, "translationY", 300f)
        val animY = ObjectAnimator.ofFloat(mWelcomeTv, "y", 100f)
        val animSetXY = AnimatorSet()
        animSetXY.playTogether(animX, animY)
        animX.start()

        val animRotateClockwise = ObjectAnimator.ofFloat(mWelcomeTv, "rotationY", 0f, 360f)
        animRotateClockwise.duration = 4000
        animRotateClockwise.start()
        mWelcomeTv.setOnClickListener{
            val springAnim = SpringAnimation(mWelcomeTv, DynamicAnimation.X, 0f)
            springAnim.spring.dampingRatio=5f
            springAnim.spring.stiffness=0.2f
            springAnim.start()
        }

    }
}
