package com.kotlin.android.androidkotlin.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.android.androidkotlin.R
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        mClickBtn.setOnClickListener {
            var num: Int = Integer.parseInt(mNumberTv.text.toString())
            num++
            mNumberTv.text = num.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putInt("num", Integer.parseInt(mNumberTv.text.toString()))
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState?.run {
            mNumberTv.text = getInt("num").toString()
        }
    }
}
