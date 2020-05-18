package com.example.presentation.base.adapter

import com.example.domain.entity.DomainObject
import com.example.domain.entity.LoadMoreObject
import com.example.presentation.R

object ViewTypeHolder {

    val LOAD_MORE_VIEW: Int = R.layout.adapter_load_more

    fun getView(obj: DomainObject?): Int {
        if (obj == null) return 0
        return when (obj::class) {
            LoadMoreObject::class -> LOAD_MORE_VIEW
            else -> 0
        }
    }
}
