package com.kotlin.android.androidkotlin.views

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.android.androidkotlin.R
import com.kotlin.android.androidkotlin.viewmodels.ScoreViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var viewModel = ScoreViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        mScoreTv.text = viewModel.scoreTeamA.toString()
        mTeamABtn.setOnClickListener {
            incrementUsingModelView()
//            incrementWithoutModelView()
        }
    }

    fun incrementWithoutModelView() {
        var oldScore = mScoreTv.text.toString()
        var newScore = oldScore.toInt()
        newScore++
        mScoreTv.text = newScore.toString()
    }

    fun incrementUsingModelView() {
        viewModel.scoreTeamA++
        mScoreTv.text = viewModel.scoreTeamA.toString()
    }
}
