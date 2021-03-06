package com.example.presentation.base.adapter

import com.example.domain.entity.DomainObject

interface IRecyclerAdapter {
    fun <T : DomainObject> addItem(index: Int, item: T)

    fun <T : DomainObject> addItem(item: T)

    fun <T : DomainObject> addItems(items: MutableList<out T>)

    fun addItemsList(items: List<*>)

    fun <T : DomainObject> addItemsWithoutClear(items: MutableList<out T>)

    fun remove(index: Int)

    fun removeAll()
}