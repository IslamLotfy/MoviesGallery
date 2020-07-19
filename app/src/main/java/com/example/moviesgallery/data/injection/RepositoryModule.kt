package com.example.moviesgallery.data.injection

import com.example.moviesgallery.data.mappers.MovieMapper
import com.example.moviesgallery.data.remotedatasource.ServiceApi
import com.example.moviesgallery.data.repository.RepositoryImplementer
import com.example.moviesgallery.domain.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieMapper() = MovieMapper()

    @Singleton
    @Provides
    fun providesMoviesRepository(service: ServiceApi, movieMapper: MovieMapper): Repository {
        return RepositoryImplementer(serviceApi = service, movieMapper = movieMapper)
    }
}