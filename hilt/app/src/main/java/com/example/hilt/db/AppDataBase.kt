package com.example.hilt.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hilt.db.UserEntity
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    companion object{
        private var dbInstance:AppDataBase? =null
        fun getAppDB(context: Context):AppDataBase{
            if (dbInstance == null){
                dbInstance = Room.databaseBuilder<AppDataBase>(
                    context.applicationContext, AppDataBase::class.java,"MYDB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return dbInstance!!
        }
    }
    abstract fun getDAO():AppDao
}