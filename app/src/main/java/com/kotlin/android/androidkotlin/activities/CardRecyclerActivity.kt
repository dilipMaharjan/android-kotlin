package com.kotlin.android.androidkotlin.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.android.androidkotlin.R
import com.kotlin.android.androidkotlin.adapter.UserAdapter
import com.kotlin.android.androidkotlin.models.User
import kotlinx.android.synthetic.main.activity_card_recycler.*

class CardRecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_recycler)
        var layoutManager = GridLayoutManager(this, 3) as RecyclerView.LayoutManager
        card_recycler.layoutManager = layoutManager
        card_recycler.itemAnimator = DefaultItemAnimator()
        val adapter = UserAdapter(this, list())
        card_recycler.adapter = adapter
    }

    fun list(): ArrayList<User> {
        return arrayListOf(
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello"),
                User(R.drawable.abc_ic_star_black_16dp, "hello")
        )
    }
}
