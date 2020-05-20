package com.example.presentation.ui.venue.fragments.list.view.adapter

import android.view.View
import com.example.domain.entity.venue.VenueObject
import com.example.presentation.base.adapter.BaseViewHolder
import com.example.presentation.base.adapter.ViewTypeHolder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_venue.view.*

open class VenuesViewHolder(override val containerView: View) :
    BaseViewHolder<VenueObject>(containerView),
    LayoutContainer {

    override fun getType(): Int = ViewTypeHolder.VENUE_VIEW

    override fun bind(data: VenueObject?) {
        itemView.itemVenueTitle.text = data?.name
    }

}
