package com.example.coroutines_hilt_flow.data.local

import androidx.room.*
import com.example.coroutines_hilt_flow.model.Movie

@Dao
interface MovieDao {

    @Query("Select * From movie order by popularity DESC")
    fun getAll():List<Movie>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movie: List<Movie>)

    @Delete
    fun delete(movie: Movie)

    @Delete
    fun deleteAll(movie: List<Movie>)
}