package com.example.presentation.base.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    protected val mSubject = PublishSubject.create<BaseAction>()

    abstract fun getType(): Int

    abstract fun bind(data: T?)

    fun observe(): Observable<BaseAction> {
        return mSubject.hide()
    }
}