package com.t4zb.kotlinapitesting.util

import android.content.Context
import android.util.Log
import android.widget.Toast

fun showLogError(tag: String, string: String) {
    Log.i(tag, "showLogError: $string")
}

fun showLogDebug(tag: String, string: String) {
    Log.d(tag, "showLogError: $string")
}

fun showToast(context: Context, string: String) {
    Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
}
