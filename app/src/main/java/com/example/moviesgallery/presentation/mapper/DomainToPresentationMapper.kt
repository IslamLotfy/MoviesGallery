package com.example.moviesgallery.presentation.mapper

interface DomainToPresentationMapper<R,E> {
    fun mapFromDomnainToPresnetation(model: R): E
}