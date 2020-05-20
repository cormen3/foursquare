package com.example.domain.entity.venue

data class Group(
    val name: String = "",
    val type: String = "",
    val items: List<VenueItem>
    )