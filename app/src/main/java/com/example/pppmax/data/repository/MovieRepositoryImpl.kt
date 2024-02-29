package com.example.pppmax.data.repository

import com.example.pppmax.data.api.MovieApi
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(private val api: MovieApi) : MovieRepository {
    override suspend fun getMovieById(id: String) = flow {
        val response = api.getMovie(id)
        val movie = response.results[0]
        emit(movie)
    }
}