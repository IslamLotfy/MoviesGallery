package com.example.moviesgallery.domain.usecases

import com.example.moviesgallery.domain.Repository
import com.example.moviesgallery.domain.Result
import com.example.moviesgallery.domain.entities.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(private val repository: Repository) {
    //    val topRatedMovies: Flow<Result<List<MovieEntity>>> = repository.getTopRatedMovies()
    fun getTopRatedMovies(): Flow<Result<List<MovieEntity>>> = repository.getTopRatedMovies()
}