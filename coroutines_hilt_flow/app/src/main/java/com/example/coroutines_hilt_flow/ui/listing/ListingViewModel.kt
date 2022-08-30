package com.example.coroutines_hilt_flow.ui.listing
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutines_hilt_flow.data.MovieRepository
import com.example.coroutines_hilt_flow.model.Result
import com.example.coroutines_hilt_flow.model.TrendingMovieResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
class ListingViewModel @ViewModelInject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    private val _movieList = MutableLiveData<Result<TrendingMovieResponse>>()
    val movieList = _movieList

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            movieRepository.fetchTrendingMovies().collect {
                _movieList.value = it
            }
        }
    }
}