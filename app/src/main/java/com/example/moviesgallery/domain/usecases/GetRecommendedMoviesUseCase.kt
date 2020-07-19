package com.example.moviesgallery.domain.usecases

import com.example.moviesgallery.domain.Repository
import javax.inject.Inject

class GetRecommendedMoviesUseCase @Inject constructor(private val repository: Repository) {
    fun getRecommendedMovies(movieId: Int) = repository.getRecommendedMovies(movieId)
}