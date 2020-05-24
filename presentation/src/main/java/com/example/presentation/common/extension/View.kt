package com.example.presentation.common.extension

import android.view.View

fun View.goneOrVisible(visible: Boolean) {
    if (visible && this.visibility != View.VISIBLE)
        this.visible()
    else
        this.gone()
}

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}