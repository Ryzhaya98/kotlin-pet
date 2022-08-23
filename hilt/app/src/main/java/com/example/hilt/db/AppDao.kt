package com.example.hilt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("Select * from user order by id desc")
    fun getRecord():List<UserEntity>

    @Insert
    fun insertRecord(userEntity: UserEntity)
}