package com.example.news_app_mvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app_mvvm.util.Resource
import com.example.news_app_mvvm.repository.NewsRepository
import com.example.news_app_mvvm.models.NeswResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(val newsRepository:NewsRepository): ViewModel() {

    val breakongNews:MutableLiveData<Resource<NeswResponse>> = MutableLiveData()
    val breakingNewsPage=1

    init {
        getBreakingNews("us")
    }
    fun getBreakingNews(countryCode:String)= viewModelScope.launch {
        breakongNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode,breakingNewsPage)
        breakongNews.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response:Response<NeswResponse>):Resource<NeswResponse>{
        if (response.isSuccessful){
             response.body()?.let {
                resultResponse->return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}