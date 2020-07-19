package com.example.moviesgallery.presentation.injection

import com.example.moviesgallery.presentation.mapper.MovieMapper
import com.we.movieapp.ui.viewmodel.BaseSchedulerProvider
import com.we.movieapp.ui.viewmodel.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun providesTaskBaseScheduler(): BaseSchedulerProvider =
        SchedulerProvider()

    @Singleton
    @Provides
    fun providesMoviesMapper() = MovieMapper()
}