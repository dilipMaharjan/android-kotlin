package com.kotlin.android.androidkotlin.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.android.androidkotlin.R
import com.kotlin.android.androidkotlin.kotlin.Authenticate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mLoginBtn.setOnClickListener {
            val username = mUsernameTv.text.toString()
            val auth = Authenticate().login(username.trim(), mPasswordTv.text.toString().trim())
            if (auth) {
                val intent = Intent(this, DashboardActivity::class.java).apply {
                    putExtra("username", username)
                }
                startActivity(intent)
            }
        }
    }

}
