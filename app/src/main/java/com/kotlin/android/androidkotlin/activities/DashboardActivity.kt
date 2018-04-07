package com.kotlin.android.androidkotlin.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kotlin.android.androidkotlin.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val username = intent.getStringExtra("username")
        findViewById<TextView>(R.id.mWelcomeTv).apply {
            text = username
        }
        mWelcomeTv.setOnClickListener {
            val intent = Intent(this, LifeCycle::class.java)
            startActivity(intent)
        }
    }
}
