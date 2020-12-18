package com.example.moviesgallery.data.remotedatasource

import com.example.moviesgallery.data.models.MovieModel
import com.example.moviesgallery.data.models.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {
    @GET("/3/movie/top_rat")
    suspend fun getTopRatedMovies(): Response

    @GET("/3/movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int): Single<MovieModel>

    @GET("/3/movie/{movie_id}/recommendations")
    fun getRecommended(@Path("movie_id") movieId: Int): Single<Response>

    @GET("/3/movie/{movie_id}/similar")
    fun getSimilarMovies(@Path("movie_id") movieId: Int): Single<Response>
}