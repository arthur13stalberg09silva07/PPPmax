package com.example.pppmax.data.api

import com.example.teste2api.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("search/movie?api_key=14d85696826338f3be7b526bcea0ea65&language=pt-BR")
    suspend fun getMovie(
        @Query("query") movieId: String
    ): MovieResponse
}