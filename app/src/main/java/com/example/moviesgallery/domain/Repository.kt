package com.example.moviesgallery.domain

import com.example.moviesgallery.domain.entities.MovieEntity
import io.reactivex.Single

interface Repository {
    fun getTopRatedMovies(): Single<List<MovieEntity>>

    fun getMovieDetails(movieId: Int): Single<MovieEntity>

    fun getSimilarMovies(movieId: Int): Single<List<MovieEntity>>

    fun getRecommendedMovies(movieId: Int): Single<List<MovieEntity>>
}