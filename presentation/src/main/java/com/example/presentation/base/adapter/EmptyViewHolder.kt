package com.example.presentation.base.adapter

import android.view.View
import com.example.domain.entity.DomainObject

class EmptyViewHolder(val view: View) : BaseViewHolder<DomainObject>(view) {
    override fun getType(): Int = 0
    override fun bind(data: DomainObject?) {}
}