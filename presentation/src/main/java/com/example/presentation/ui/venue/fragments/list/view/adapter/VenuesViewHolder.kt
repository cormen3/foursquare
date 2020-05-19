package com.example.presentation.ui.venue.fragments.list.view.adapter

import android.view.View
import com.example.domain.entity.venue.VenueObject
import com.example.presentation.base.adapter.BaseViewHolder
import kotlinx.android.extensions.LayoutContainer

open class VenuesViewHolder(override val containerView: View) :
    BaseViewHolder<VenueObject>(containerView),
    LayoutContainer {

    override fun bind(data: VenueObject?) {
    }

    override fun getType(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
