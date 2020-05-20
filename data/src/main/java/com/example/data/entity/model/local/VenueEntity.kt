package com.example.data.entity.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.venue.Location

@Entity(tableName = "venues")
data class VenueEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name: String = "",
    val location: Location
)