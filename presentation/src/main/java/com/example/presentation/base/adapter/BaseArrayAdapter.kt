package com.example.presentation.base.adapter

import android.content.Context
import android.widget.ArrayAdapter
import com.example.domain.entity.DomainObject

abstract class BaseArrayAdapter<T : DomainObject>(context: Context) :
    ArrayAdapter<DomainObject>(context, 0),
    IArrayAdapter {

    protected var mItems: MutableList<DomainObject> = mutableListOf()

    fun getViewType(position: Int): Int {
        return ViewTypeHolder.getView(getItem(position))
    }

    override fun <T : DomainObject> addItem(index: Int, item: T) {
        mItems.add(index, item)
        removeAll()
        addAll(mItems)
        notifyDataSetChanged()
    }

    override fun <T : DomainObject> addItems(items: MutableList<T>) {
        removeAll()
        mItems.addAll(items)
        addAll(items)
        notifyDataSetChanged()
    }

    override fun addItemsList(items: List<*>) {
        removeAll()
        items.filterIsInstance<DomainObject>().let { mItems.addAll(it) }
        addAll(mItems)
        notifyDataSetChanged()
    }

    override fun <T : DomainObject> addItemsWithoutClear(items: MutableList<T>) {
        mItems.addAll(items)
        addAll(mItems)
        notifyDataSetChanged()
    }

    override fun remove(index: Int) {
        if (mItems.size > 0) {
            mItems.removeAt(index)
            removeAll()
            addAll(mItems)
            notifyDataSetChanged()
        }
    }

    override fun removeAll() {
        mItems.clear()
        clear()
    }

    companion object {
        // Add items at first of the list
        const val FIRST = 0
    }
}