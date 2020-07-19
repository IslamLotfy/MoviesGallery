package com.example.moviesgallery.presentation.view.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.moviesgallery.domain.usecases.GetTopRatedMoviesUseCase
import com.example.moviesgallery.presentation.mapper.MovieMapper
import com.example.moviesgallery.presentation.models.MovieUIModel
import com.example.moviesgallery.presentation.utils.ViewState
import com.we.movieapp.ui.viewmodel.BaseSchedulerProvider
import com.we.movieapp.ui.viewmodel.BaseViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val movieMapper: MovieMapper,
    baseSchedulerProvider: BaseSchedulerProvider
) : BaseViewModel(baseSchedulerProvider = baseSchedulerProvider),LifecycleObserver {
    val topRatedMovies = MutableLiveData<ViewState<List<MovieUIModel>>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getTopRatedMovies() {
        execute(loadingConsumer = Consumer {
            topRatedMovies.postValue(ViewState.loading())
        }, throwableConsumer = Consumer {
            topRatedMovies.postValue(ViewState.error(it.message))
        }, successConsumer = Consumer {
            topRatedMovies.postValue(ViewState.success(it.map { movie ->
                movieMapper.mapFromDomnainToPresnetation(movie)
            }))
        }, useCase = getTopRatedMoviesUseCase.getTopRatedMovies())
    }
}