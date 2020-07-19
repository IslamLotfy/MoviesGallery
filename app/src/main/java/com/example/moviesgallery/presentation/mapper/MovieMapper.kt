package com.example.moviesgallery.presentation.mapper

import com.example.moviesgallery.domain.entities.MovieEntity
import com.example.moviesgallery.presentation.models.MovieUIModel

class MovieMapper: DomainToPresentationMapper<MovieEntity, MovieUIModel> {
    override fun mapFromDomnainToPresnetation(model: MovieEntity): MovieUIModel {
        return MovieUIModel(
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