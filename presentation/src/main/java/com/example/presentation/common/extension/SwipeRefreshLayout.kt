package com.example.presentation.common.extension

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun SwipeRefreshLayout.toggleRefreshing(refreshingStatus: Boolean) {
    if (refreshingStatus)
        this.showRefreshing()
    else
        this.hideRefreshing()
}

private fun SwipeRefreshLayout.showRefreshing() {
    if (!this.isRefreshing)
        this.post { this.isRefreshing = true }
}

private fun SwipeRefreshLayout.hideRefreshing() {
    if (this.isRefreshing)
        this.post { isRefreshing = false }
}
