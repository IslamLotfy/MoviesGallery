package com.example.moviesgallery.data.models


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movieModels: List<MovieModel>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)