package com.example.moviesgallery.presentation

import com.example.moviesgallery.presentation.injection.AppComponent
import com.example.moviesgallery.presentation.injection.DaggerAppComponent
import dagger.android.DaggerApplication

class MoviesGallery : DaggerApplication() {
    override fun applicationInjector(): AppComponent {
        return DaggerAppComponent.builder().application(this).build()
    }
}