package com.example.moviesgallery.data.repository

import com.example.moviesgallery.data.mappers.MovieMapper
import com.example.moviesgallery.data.remotedatasource.ServiceApi
import com.example.moviesgallery.domain.Repository
import com.example.moviesgallery.domain.entities.MovieEntity
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImplementer @Inject constructor(
    private val serviceApi: ServiceApi,
    private val movieMapper: MovieMapper
) : Repository {
    override fun getTopRatedMovies(): Single<List<MovieEntity>> {
        return serviceApi.getTopRatedMovies().map { respoponse ->
            respoponse.movieModels.map { movieModel ->
                movieMapper.mapFromDataToDomainModel(movieModel)
            }
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