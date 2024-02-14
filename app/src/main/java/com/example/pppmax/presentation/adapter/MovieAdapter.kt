package com.example.pppmax.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.pppmax.R
import com.example.pppmax.domain.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movies: List<Movie> = listOf()

    fun setMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val idTextView: TextView = itemView.findViewById(R.id.textViewId)
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        private val overviewTextView: TextView = itemView.findViewById(R.id.textViewOverview)
        private val posterImageView: ImageView = itemView.findViewById(R.id.imageViewPoster)

        fun bind(movie: Movie) {
            idTextView.text = movie.id
            titleTextView.text = movie.title
            overviewTextView.text = movie.overview

            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500/${movie.backdrop_path}")
                .placeholder(R.drawable.placeholder_image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(posterImageView)
        }
    }
}