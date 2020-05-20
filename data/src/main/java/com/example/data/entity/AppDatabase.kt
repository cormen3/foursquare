package com.example.data.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.entity.model.local.VenueEntity

@TypeConverters(VenuesConverter::class)
@Database(
    entities = [
        VenueEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun venuesDao(): VenuesDao
}
