package com.example.moviesgallery.data.repository

import android.util.Log
import com.example.moviesgallery.data.mappers.MovieMapper
import com.example.moviesgallery.data.remotedatasource.RemoteDataSource
import com.example.moviesgallery.data.remotedatasource.ServiceApi
import com.example.moviesgallery.domain.IErrorHandler
import com.example.moviesgallery.domain.Repository
import com.example.moviesgallery.domain.Result
import com.example.moviesgallery.domain.entities.MovieEntity
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryImplementer @Inject constructor(
    private val serviceApi: ServiceApi,
    private val remoteDataSource: RemoteDataSource,
    private val movieMapper: MovieMapper,
    private val errorHandler: IErrorHandler
) : Repository {
    override fun getTopRatedMovies(): Flow<Result<List<MovieEntity>>> {
        return remoteDataSource.getTopRatedMovies()
            .map {

                Result.Success(it.movieModels.map { movieModel ->
                    movieMapper.mapFromDataToDomainModel(movieModel)
                }) as Result<List<MovieEntity>>
            }
            .catch {
                Log.e("heereee", it.toString())
                emit(Result.Error(errorHandler.getError(it)))
            }

    }

    override fun getMovieDetails(movieId: Int): Single<MovieEntity> {
        return serviceApi.getMovieDetail(movieId).map { movieModel ->
            movieMapper.mapFromDataToDomainModel(movieModel)
        }
    }

    override fun getSimilarMovies(movieId: Int): Single<List<MovieEntity>> {
        return serviceApi.getSimilarMovies(movieId).map { response ->
            response.movieModels.map { movieModel ->
                movieMapper.mapFromDataToDomainModel(movieModel)
            }
        }
    }

    override fun getRecommendedMovies(movieId: Int): Single<List<MovieEntity>> {
        return serviceApi.getRecommended(movieId).map { response ->
            response.movieModels.map { movieModel ->
                movieMapper.mapFromDataToDomainModel(movieModel)
            }
        }
    }
}