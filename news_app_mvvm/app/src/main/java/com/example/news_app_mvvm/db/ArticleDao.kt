package com.example.news_app_mvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.news_app_mvvm.models.Article
@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article):Long

    @Query("Select * from articles")
    fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)


}