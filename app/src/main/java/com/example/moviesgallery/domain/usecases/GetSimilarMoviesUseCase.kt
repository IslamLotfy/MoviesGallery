package com.example.moviesgallery.domain.usecases

import com.example.moviesgallery.domain.Repository
import javax.inject.Inject

class GetSimilarMoviesUseCase @Inject constructor(private val repository: Repository) {
    fun getSimilarMovies(movieId: Int) = repository.getSimilarMovies(movieId)
}