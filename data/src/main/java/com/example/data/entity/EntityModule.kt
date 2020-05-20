package com.example.data.entity

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EntityModule {
    @Provides
    fun venuesDao(db: AppDatabase) = db.venuesDao()

    @Provides
    @Singleton
    fun database(application: Application): AppDatabase = Room.databaseBuilder(
        application.applicationContext,
        AppDatabase::class.java,
        "app_database"
    )
        .build()
}
