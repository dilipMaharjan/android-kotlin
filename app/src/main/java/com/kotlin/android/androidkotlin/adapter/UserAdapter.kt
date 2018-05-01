package com.kotlin.android.androidkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.android.androidkotlin.R
import com.kotlin.android.androidkotlin.models.User
import kotlinx.android.synthetic.main.list_item_card.view.*


/**
 * Created by Dilip Maharjan on 05/01/2018
 */
class UserAdapter(private val context: Context, private val items: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = items[position]
        holder?.identicon?.setImageResource(user.identicon)
        holder?.text?.text = user.text
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val identicon = view.identicon
        val text = view.text
    }
}


