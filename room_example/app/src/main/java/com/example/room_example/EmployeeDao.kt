package com.example.room_example

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import androidx.room.Delete
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable

@Dao
interface EmployeeDao{
    @Query("SELECT * FROM employee_info")
    fun getAllEmployee(): List<Employee>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployee(employee: Employee): Completable

    @Delete
    fun deleteEmployee(employee: Employee): Completable

    @Update
    fun updateEmployee(employee: Employee): Completable
}