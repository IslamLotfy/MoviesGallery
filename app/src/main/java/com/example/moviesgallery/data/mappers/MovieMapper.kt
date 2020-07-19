package com.example.moviesgallery.data.mappers

import com.example.moviesgallery.data.models.MovieModel
import com.example.moviesgallery.domain.entities.MovieEntity

class MovieMapper : DataToDomainMapper<MovieModel, MovieEntity> {
    override fun mapFromDataToDomainModel(model: MovieModel): MovieEntity {
        return MovieEntity(
            adult = model.adult,
            title = model.title,
            releaseDate = model.releaseDate,
            posterPath = model.posterPath,
            popularity = model.popularity,
            overview = model.overview,
            originalTitle = model.originalTitle,
            originalLanguage = model.originalLanguage,
            id = model.id,
            genreIds = model.genreIds,
            backdropPath = model.backdropPath,
            video = model.video,
            voteAverage = model.voteAverage,
            voteCount = model.voteCount
        )
    }

}