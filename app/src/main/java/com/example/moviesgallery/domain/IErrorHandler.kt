package com.example.moviesgallery.domain

interface IErrorHandler {
    fun getError(throwable: Throwable): ErrorEntity
}