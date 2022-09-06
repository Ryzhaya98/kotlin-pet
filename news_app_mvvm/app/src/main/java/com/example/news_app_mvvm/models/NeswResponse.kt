package com.example.news_app_mvvm.models


import com.example.news_app_mvvm.models.Article
import com.google.gson.annotations.SerializedName

data class NeswResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)