package com.kotlin.android.androidkotlin

import junit.framework.Assert.assertTrue
import org.junit.Test
import com.kotlin.android.androidkotlin.kotlin.Authenticate

class AuthenticateTest {
    @Test
    fun loginTest() {
        var auth = Authenticate().login("john", "password")
        assertTrue(auth)
    }
}