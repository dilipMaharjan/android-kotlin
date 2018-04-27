package com.kotlin.android.androidkotlin.activities

import android.content.Intent
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
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
            duration=1000
            alpha(0.2f)
            start()
        }
    }

    //view animator
    fun animateView(view: View) {
        animateViewWithCode(view)
        animateViewWithXml(view)
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

}
