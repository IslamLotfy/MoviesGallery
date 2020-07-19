package com.example.moviesgallery.presentation.view.home

import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesgallery.R
import com.example.moviesgallery.databinding.MovieListItemBinding
import com.example.moviesgallery.domain.entities.MovieEntity
import com.example.moviesgallery.presentation.models.MovieUIModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class HomeMovieAdapter : RecyclerView.Adapter<HomeMovieAdapter.ViewHolder>() {

    private val movies: MutableList<MovieUIModel> = ArrayList()
    private var layoutInflater: LayoutInflater? = null

    var onMovieClickListener: OnMovieClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }

        val binding: MovieListItemBinding =
            DataBindingUtil.inflate(layoutInflater!!, R.layout.movie_list_item, parent, false)

        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.binding.movieTitle.text = movies[position].title
        Handler().postDelayed(Runnable {  Picasso.get()
            .load("https://image.tmdb.org/t/p/w200/${movies[position].posterPath}")
            .into(viewHolder.binding.movieImage, object : Callback {
                override fun onSuccess() {
                    viewHolder.binding.imageProgress.hide()
                }

                override fun onError(e: Exception?) {
                    viewHolder.binding.imageProgress.hide()
                }

            }
            )},1000)

        viewHolder.binding.itemView.setOnClickListener {
            onMovieClickListener?.setOnMovieClickListener(movies[position].id)
        }

    }

    override fun getItemCount() = movies.size

    fun submitList(newMovies: List<MovieUIModel>?) {
        newMovies?.let {
            movies.addAll(it)
            val uniqueMovieList = movies.distinctBy { movie ->
                movie.id
            }
            movies.clear()
            movies.addAll(uniqueMovieList)
            notifyDataSetChanged()
        }
    }

    @Suppress("unused")
    fun clear() {
        movies.clear()
        notifyDataSetChanged()
    }

    interface OnMovieClickListener {
        fun setOnMovieClickListener(movieId: Int)
    }

    class ViewHolder(val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}
