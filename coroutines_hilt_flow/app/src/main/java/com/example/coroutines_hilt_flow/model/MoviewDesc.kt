package com.example.coroutines_hilt_flow.model

data class MovieDesc(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val genres: List<GenreSingle>
)

data class GenreSingle(val id: Int, val name: String)