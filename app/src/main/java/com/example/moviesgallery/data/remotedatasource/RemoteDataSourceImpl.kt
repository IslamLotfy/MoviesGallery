package com.example.moviesgallery.data.remotedatasource

import com.example.moviesgallery.data.models.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val remoteApi: ServiceApi
) : RemoteDataSource {
    override fun getTopRatedMovies(): Flow<Response> {
        return flow {
            val response = remoteApi.getTopRatedMovies()
            emit(response)
        }
    }

}