package com.example.moviesgallery.data.injection

import com.example.moviesgallery.data.ErrorHandler
import com.example.moviesgallery.data.mappers.MovieMapper
import com.example.moviesgallery.data.remotedatasource.RemoteDataSource
import com.example.moviesgallery.data.remotedatasource.RemoteDataSourceImpl
import com.example.moviesgallery.data.remotedatasource.ServiceApi
import com.example.moviesgallery.data.repository.RepositoryImplementer
import com.example.moviesgallery.domain.IErrorHandler
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
    fun provideErrorHandler(): IErrorHandler {
        return ErrorHandler()
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(remoteApi: ServiceApi): RemoteDataSource {
        return RemoteDataSourceImpl(remoteApi = remoteApi)
    }

    @Singleton
    @Provides
    fun providesMoviesRepository(
        service: ServiceApi,
        remoteDataSource: RemoteDataSource,
        movieMapper: MovieMapper,
        errorHandler: IErrorHandler
    ): Repository {
        return RepositoryImplementer(
            serviceApi = service,
            remoteDataSource = remoteDataSource,
            movieMapper = movieMapper,
            errorHandler = errorHandler
        )
    }
}