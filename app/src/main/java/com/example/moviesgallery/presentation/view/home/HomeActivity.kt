package com.example.moviesgallery.presentation.view.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.moviesgallery.R
import com.example.moviesgallery.presentation.utils.ViewState
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        lifecycle.addObserver(homeViewModel)
        val homeMovieAdapter = HomeMovieAdapter()
        movie_recycler_view_list.adapter = homeMovieAdapter
        homeViewModel.topRatedMovies.observe(this, Observer {
            when (it.status) {
                ViewState.Status.LOADING -> {
                    Log.e("moviess", "loading")
                }
                ViewState.Status.ERROR -> {
                    Log.e("moviess", it.message!!)
                }
                ViewState.Status.SUCCESS -> {
                    Log.e("moviesss", it.data!!.size.toString())
                    homeMovieAdapter.submitList(it.data)
                }
            }
        })
    }
}
