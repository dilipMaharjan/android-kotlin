package com.kotlin.android.androidkotlin.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.kotlin.android.androidkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MAINACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            getViewBounds(tv)
            getMeasureWidthAndHeight(tv)
            getWidthAndHeight(tv)
            getPadding(tv)
        }
    }
    fun getViewBounds(view: View) {
        Log.i(TAG, "left-coordinate ${view.left}")
        Log.i(TAG, "top-coordinate ${view.top}")
        Log.i(TAG, "right-coordinate ${view.right}")
        Log.i(TAG, "bottom-coordinate ${view.bottom}")
    }

    fun getMeasureWidthAndHeight(view: View) {
        Log.i(TAG, "measured width  ${view.measuredWidth}")
        Log.i(TAG, "measured height  ${view.measuredHeight}")
    }

    fun getWidthAndHeight(view: View) {
        Log.i(TAG, "width ${view.width}")
        Log.i(TAG, "height ${view.height}")
    }

    fun getPadding(view: View) {
        Log.i(TAG, "paddingLeft ${view.paddingLeft}")
        Log.i(TAG, "paddingRight ${view.paddingRight}")
        Log.i(TAG, "paddingTop ${view.paddingTop}")
        Log.i(TAG, "paddingBottom ${view.paddingBottom}")
    }

}
