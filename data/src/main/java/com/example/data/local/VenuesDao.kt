package com.example.data.local

import androidx.room.*
import io.reactivex.Flowable


@Dao
@TypeConverters(VenuesConverter::class)
interface VenuesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(venue: VenueEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg venues: VenueEntity)

    @Query("SELECT * FROM venues")
    fun allVenues(): Flowable<List<VenueEntity>>

    @Query("DELETE  FROM venues")
    fun clearAll()
}
