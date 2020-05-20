package com.example.presentation.common.extension

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.presentation.R

@SuppressLint("InflateParams")
fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, text, duration).apply {
        val layout = LayoutInflater.from(this@toast).inflate(R.layout.layout_toast, null)
        val tv = layout.findViewById<AppCompatTextView>(android.R.id.message)
        tv.text = text
        this.view = layout
    }.show()

fun Context.toast(@StringRes textId: Int, duration: Int = Toast.LENGTH_SHORT) {
    val text = this.getString(textId)
    Toast.makeText(this, text, duration).apply {
        val layout = LayoutInflater.from(this@toast).inflate(R.layout.layout_toast, null)
        val tv = layout.findViewById<AppCompatTextView>(android.R.id.message)
        tv.text = text
        this.view = layout
    }.show()
}
