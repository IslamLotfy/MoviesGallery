package com.example.moviesgallery.domain

import com.example.moviesgallery.data.injection.RepositoryModule
import com.example.moviesgallery.domain.usecases.GetMovieDetailsUseCase
import com.example.moviesgallery.domain.usecases.GetRecommendedMoviesUseCase
import com.example.moviesgallery.domain.usecases.GetSimilarMoviesUseCase
import com.example.moviesgallery.domain.usecases.GetTopRatedMoviesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RepositoryModule::class])
class UseCasesModule {
    @Singleton
    @Provides
    fun provideGetTopRatedUseCase(repository: Repository) = GetTopRatedMoviesUseCase(repository = repository)

    @Singleton
    @Provides
    fun provideGetMovieDetailsUseCase(repository: Repository) = GetMovieDetailsUseCase(repository = repository)

    @Singleton
    @Provides
    fun provideGetRecommendedMoviesUseCase(repository: Repository) = GetRecommendedMoviesUseCase(repository = repository)

    @Singleton
    @Provides
    fun provideGetSimilarMoviesUseCase(repository: Repository) = GetSimilarMoviesUseCase(repository = repository)
}