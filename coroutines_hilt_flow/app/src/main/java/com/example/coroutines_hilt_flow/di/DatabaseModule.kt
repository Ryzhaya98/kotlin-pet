package com.example.coroutines_hilt_flow.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import com.example.coroutines_hilt_flow.data.local.AppDatabase
import com.example.coroutines_hilt_flow.data.local.MovieDao
@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext:Context):AppDatabase{
        return Room.databaseBuilder(
            appContext,AppDatabase::class.java,
            "app.db"
        ).build()
    }
    @Provides
    fun provideMovieDao(appDatabase: AppDatabase):MovieDao{
        return appDatabase.movieDao()
    }
}