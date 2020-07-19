package com.example.moviesgallery.domain.usecases

import com.example.moviesgallery.domain.Repository
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(private val repository: Repository) {
    fun getTopRatedMovies() = repository.getTopRatedMovies()
}