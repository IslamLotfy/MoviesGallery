package com.example.moviesgallery.domain

import com.example.moviesgallery.domain.entities.MovieEntity
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getTopRatedMovies(): Flow<Result<List<MovieEntity>>>

    fun getMovieDetails(movieId: Int): Single<MovieEntity>

    fun getSimilarMovies(movieId: Int): Single<List<MovieEntity>>

    fun getRecommendedMovies(movieId: Int): Single<List<MovieEntity>>
}