package com.example.coroutines_hilt_flow.network.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.coroutines_hilt_flow.model.TrendingMovieResponse
import com.example.coroutines_hilt_flow.model.Movie
import com.example.coroutines_hilt_flow.model.MovieDesc
interface MovieService {

    @GET("/3/trending/movie/week")
    suspend fun getPopularMovies() : Response<TrendingMovieResponse>

    @GET("/3/movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int) : Response<MovieDesc>
}