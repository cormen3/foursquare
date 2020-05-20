package com.example.presentation.common.extension

import android.view.View

fun View.goneOrVisible(visible: Boolean) {
    if (visible)
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

fun View.invisible() {
    visibility = View.INVISIBLE
}


