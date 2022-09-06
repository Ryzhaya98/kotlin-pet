package com.example.news_app_mvvm.util

sealed class Resource<T>(
    val data: T?=null,
    val mess:String?=null
) {
    class Success<T>(data: T):Resource<T>(data)
    class Error<T>(mess: String, data: T? = null):Resource<T>(data,mess)
    class Loading<T>:Resource<T>()

}