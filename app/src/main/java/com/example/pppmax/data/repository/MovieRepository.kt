package com.example.pppmax.data.repository

import com.example.pppmax.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMovieById(id:String): Flow<Movie>
}