package com.example.pppmax.data.repository

import com.example.pppmax.domain.model.Movie
import com.example.teste2api.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(private val api: MovieApi): MovieRepository {
    override suspend fun getMovieById(id:String): Flow<Movie> = flow {
        val response = api.getMovie(id)
        val movie = response.results[0]
        emit(movie)
    }
}