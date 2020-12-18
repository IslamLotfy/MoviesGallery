package com.example.moviesgallery.data.mappers

interface DataToDomainMapper<R, E> {
    fun mapFromDataToDomainModel(model: R): E
}