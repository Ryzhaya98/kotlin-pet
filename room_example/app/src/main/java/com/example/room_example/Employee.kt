package com.example.room_example

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "employee_info")
data class Employee (
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name:String?,
    @ColumnInfo(name = "salary") val salary:Int?

):Serializable



