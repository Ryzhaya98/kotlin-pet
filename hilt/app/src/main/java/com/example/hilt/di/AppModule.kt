package com.example.hilt.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.hilt.db.AppDataBase
import com.example.hilt.db.AppDao
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppDB(context: Application):AppDataBase{
        return AppDataBase.getAppDB(context)
    }

    @Singleton
    @Provides
    fun getDao(appDB: AppDataBase) :AppDao{
        return appDB.getDAO()
    }


}