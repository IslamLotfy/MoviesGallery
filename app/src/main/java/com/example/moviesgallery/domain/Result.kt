package com.example.moviesgallery.domain

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: ErrorEntity) : Result<Nothing>()
}