package com.example.kotlin_crypto


import com.google.gson.annotations.SerializedName

data class Pager(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("max_page")
    val maxPage: Int,
    @SerializedName("results_per_page")
    val resultsPerPage: Int,
    @SerializedName("total_results")
    val totalResults: Int
)