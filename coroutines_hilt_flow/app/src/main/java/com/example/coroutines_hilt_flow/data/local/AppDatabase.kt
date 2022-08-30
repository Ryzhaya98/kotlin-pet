package com.example.coroutines_hilt_flow.data.local

import com.example.coroutines_hilt_flow.model.Movie
import com.example.coroutines_hilt_flow.data.GenreConverters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Movie::class], version = 1)
@TypeConverters(GenreConverters::class)
abstract class AppDatabase:RoomDatabase() {
    abstract fun movieDao(): MovieDao
}