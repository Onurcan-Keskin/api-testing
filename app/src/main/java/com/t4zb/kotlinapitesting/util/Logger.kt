package com.t4zb.kotlinapitesting.util

import android.util.Log

fun showLogError(tag:String, string: String){
    Log.i(tag, "showLogError: $string")
}

fun showLogDebug(tag:String, string: String){
    Log.d(tag, "showLogError: $string")
}

