package com.example.presentation.ui.venue.fragments.list.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.entity.DomainObject
import com.example.presentation.base.adapter.*

class VenuesAdapter(
    private val listener: (holder: BaseViewHolder<*>) -> Unit
) : BaseRecyclerAdapter(CONFIG) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        val holder = when (viewType) {
            ViewTypeHolder.LOAD_MORE_VIEW -> LoadMoreViewHolder(view)
            else -> EmptyViewHolder(view)
        }

        listener.invoke(holder)
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        super.onBindViewHolder(holder, position)

        when (holder.getType()) {
            ViewTypeHolder.LOAD_MORE_VIEW -> (holder as LoadMoreViewHolder).bind(Unit)
        }
    }

    override fun <T : DomainObject> addItems(items: MutableList<T>) {
        removeAll()
        super.addItemsWithoutClear(items)
    }

    companion object {
        val CONFIG = Config.Builder()
            .setPreFetch(20)
            .setScreenSize(5)
            .build()
    }
}