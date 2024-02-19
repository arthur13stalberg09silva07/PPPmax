package com.example.teste2api

import com.example.pppmax.domain.model.Movie
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
        @GET("movie/{movie_id}?api_key=14d85696826338f3be7b526bcea0ea65&language=pt-BR")
    suspend fun getMovie(
        @Path("movie_id") movieId: String
    ): Movie
}