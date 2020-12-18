package com.example.moviesgallery.data.remotedatasource

import com.example.moviesgallery.data.models.Response
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getTopRatedMovies(): Flow<Response>
}