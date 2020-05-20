package com.example.data.entity

import androidx.room.TypeConverter
import com.example.domain.entity.venue.Location
import com.google.gson.Gson

class VenuesConverter {

    @TypeConverter
    fun locationToJson(value: Location): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun stringToLocation(value: String): Location {
        return Gson().fromJson(value, Location::class.java)
    }
}
