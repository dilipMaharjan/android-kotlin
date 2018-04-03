package com.kotlin.android.androidkotlin.kotlin

class Authenticate {

    fun login(username: String, password: String): Boolean {
        return username.equals("john") && password.equals("password")
    }
}