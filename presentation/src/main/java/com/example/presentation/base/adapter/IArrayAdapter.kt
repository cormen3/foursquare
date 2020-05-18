package com.example.presentation.base.adapter

import com.example.domain.entity.DomainObject


interface IArrayAdapter {
    fun <T : DomainObject> addItem(index: Int, item: T)

    fun <T : DomainObject> addItems(items: MutableList<T>)

    fun addItemsList(items: List<*>)

    fun <T : DomainObject> addItemsWithoutClear(items: MutableList<T>)

    fun remove(index: Int)

    fun removeAll()
}