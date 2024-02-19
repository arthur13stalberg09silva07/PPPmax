package com.example.teste2api

import com.example.pppmax.domain.model.Movie
import retrofit2.http.GET
interface MovieApi {
        @GET("movie/550?api_key=14d85696826338f3be7b526bcea0ea65&language=pt-BR")
    suspend fun getMovie(
    ): Movie
}