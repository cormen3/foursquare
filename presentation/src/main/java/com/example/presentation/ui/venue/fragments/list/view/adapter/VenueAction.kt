package com.example.presentation.ui.venue.fragments.list.view.adapter

import com.example.domain.entity.venue.VenueObject
import com.example.presentation.base.adapter.ActionType
import com.example.presentation.base.adapter.BaseAction

class VenueAction(val data: VenueObject) : BaseAction {
    override fun getType(): ActionType = ActionType.VENUE
}