package com.example.presentation.ui.venue.fragments.list.view.adapter

import android.view.View
import com.example.domain.entity.venue.VenueObject
import com.example.presentation.R
import com.example.presentation.base.adapter.BaseViewHolder
import com.example.presentation.base.adapter.ViewTypeHolder
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_venue.*

open class VenuesViewHolder(override val containerView: View) :
    BaseViewHolder<VenueObject>(containerView),
    LayoutContainer {

    override fun getType(): Int = ViewTypeHolder.VENUE_VIEW

    override fun bind(data: VenueObject?) {
        data?.let {venue ->
            itemVenueTitle.text = venue.name
            itemVenueDistance.text = venue.location?.distance.toString().plus(
                containerView.context.getString(R.string.meters)
            )
            itemVenueAddress.text = venue.location?.address
            itemVenueFormattedAddress.text =
                venue.location?.formattedAddress?.joinToString(",")

            itemVenueRootLayout.setOnClickListener {
                mSubject.onNext(VenueAction(venue))
            }
        }
    }
}
