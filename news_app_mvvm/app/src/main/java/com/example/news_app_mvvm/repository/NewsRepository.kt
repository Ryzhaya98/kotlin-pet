package com.example.news_app_mvvm.repository
import com.example.news_app_mvvm.db.ArticleDatabase
import com.example.news_app_mvvm.api.RetrofitInstance
class NewsRepository(  val db:ArticleDatabase) {

    suspend fun getBreakingNews(countryCode:String, pageNumber:Int)=
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

}