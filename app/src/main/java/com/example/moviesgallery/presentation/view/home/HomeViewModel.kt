package com.example.moviesgallery.presentation.view.home

import android.util.Log
import androidx.lifecycle.*
import com.example.moviesgallery.domain.ErrorEntity
import com.example.moviesgallery.domain.Result
import com.example.moviesgallery.domain.usecases.GetTopRatedMoviesUseCase
import com.example.moviesgallery.presentation.mapper.MovieMapper
import com.example.moviesgallery.presentation.models.MovieUIModel
import com.example.moviesgallery.presentation.utils.ViewState
import com.we.movieapp.ui.viewmodel.BaseSchedulerProvider
import com.we.movieapp.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val movieMapper: MovieMapper,
    baseSchedulerProvider: BaseSchedulerProvider
) : BaseViewModel(baseSchedulerProvider = baseSchedulerProvider), LifecycleObserver {
    val topRatedMovies = MutableLiveData<ViewState<List<MovieUIModel>>>()

    @InternalCoroutinesApi
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getTopRatedMovies() {
        viewModelScope.launch {
            getTopRatedMoviesUseCase.getTopRatedMovies().collect { it ->
                when (it) {
                    is Result.Success -> {
                        topRatedMovies.postValue(
                            ViewState.success(
                                it.data.map {
                                    movieMapper.mapFromDomnainToPresnetation(it)
                                })
                        )
                    }
                    is Result.Error -> {
                        Log.e("errorrrrr", it.exception.toString())
                        topRatedMovies.postValue(
                            ViewState.error(
                                when (it.exception) {
                                    is ErrorEntity.NetworkError -> it.exception.message
                                    else -> "an Error Occurred"
                                }
                            )
                        )
                    }
                }

            }
        }
//        execute(loadingConsumer = Consumer {
//            topRatedMovies.postValue(ViewState.loading())
//        }, throwableConsumer = Consumer {
//            Log.e("result","errrorrrrrr")
//            topRatedMovies.postValue(ViewState.error(it.message))
//        }, successConsumer = Consumer {
//            Log.e("result","successsssssss")
//            topRatedMovies.postValue(ViewState.loading())
//        }, useCase = getTopRatedMoviesUseCase.getTopRatedMovies())
    }
}