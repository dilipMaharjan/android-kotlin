package com.kotlin.android.androidkotlin.activities

import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kotlin.android.androidkotlin.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val email = intent.getStringExtra("email")
        findViewById<TextView>(R.id.mWelcomeTv).apply {
            text = email
        }
        dashboard.setBackgroundResource(R.drawable.drawable_animation)
        val anim:AnimationDrawable=dashboard.background as AnimationDrawable
        dashboard.setOnClickListener {
            anim.start()
        }
    }
}
