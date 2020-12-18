package com.example.moviesgallery.domain.usecases

import com.example.moviesgallery.domain.Repository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: Repository) {
    fun getMovieDetails(movieId: Int) = repository.getMovieDetails(movieId)
}