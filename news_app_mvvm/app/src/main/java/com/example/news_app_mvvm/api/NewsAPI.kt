package com.example.news_app_mvvm.api

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.news_app_mvvm.util.Contants.Companion.API_KEY
import com.example.news_app_mvvm.models.NeswResponse
import retrofit2.Response

interface NewsAPI {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String ="us",
        @Query("page")
        pageNumber:Int = 1,
        @Query("apiKey")
        apiKey:String = API_KEY
    ): Response<NeswResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber:Int = 1,
        @Query("apiKey")
        apiKey:String = API_KEY
    ):Response<NeswResponse>

}