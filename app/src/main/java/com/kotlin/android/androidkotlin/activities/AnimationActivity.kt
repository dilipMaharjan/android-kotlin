package com.kotlin.android.androidkotlin.activities

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import com.kotlin.android.androidkotlin.R
import kotlinx.android.synthetic.main.activity_circle_animation.*

class AnimationActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.circle_view -> {
                playPauseAnimation.stop()
                if (circleAnimation.isRunning) {
                    circleAnimation.stop()
                } else {
                    circleAnimation.start()
                }
            }
            R.id.play_pause -> {
                circleAnimation.stop()
                if (playPauseAnimation.isRunning) {
                    playPauseAnimation.stop()
                } else {
                    playPauseAnimation.start()
                }
            }
            R.id.play -> playAnimation.start()
        }
    }

    private lateinit var circleAnimation: AnimationDrawable
    private lateinit var playPauseAnimation: AnimationDrawable
    private lateinit var playAnimation: Animatable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_animation)
        circleAnimation = circle_view.drawable as AnimationDrawable
        playPauseAnimation = play_pause.drawable as AnimationDrawable
        playAnimation = play.drawable as Animatable
        circle_view.setOnClickListener(this)
        play_pause.setOnClickListener(this)
        play.setOnClickListener(this)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            circleAnimation.start()
            playPauseAnimation.start()
        }

        return super.onTouchEvent(event)
    }
}
