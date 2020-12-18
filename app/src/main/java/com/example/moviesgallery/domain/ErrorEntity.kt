package com.example.moviesgallery.domain

sealed class ErrorEntity {
    class NetworkError(val message: String) : ErrorEntity()
    object AccessDenied : ErrorEntity()
    object NotFound : ErrorEntity()
    object ServiceUnavailable : ErrorEntity()
    object UnKnownError : ErrorEntity()
    object BadRequest : ErrorEntity()
}