package com.example.presentation.base.adapter

import com.example.domain.entity.DomainObject
import com.example.domain.entity.LoadMoreObject
import com.example.domain.entity.venue.VenueObject
import com.example.presentation.R

object ViewTypeHolder {

    val LOAD_MORE_VIEW: Int = R.layout.adapter_load_more
    val VENUE_VIEW = R.layout.item_venue

    fun getView(obj: DomainObject?): Int {
        if (obj == null) return 0
        return when (obj::class) {
            LoadMoreObject::class -> LOAD_MORE_VIEW
            VenueObject::class -> VENUE_VIEW
            else -> 0
        }
    }
}
