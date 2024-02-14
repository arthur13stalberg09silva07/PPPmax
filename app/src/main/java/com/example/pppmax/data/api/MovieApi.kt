package com.example.teste2api

import com.example.pppmax.domain.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface MovieApi {
    @GET("movie/{movieID}")
    fun getMovie(
        @Path("movieID") movieID: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<Movie>
    @GET("movie/{movie_id}")
    fun getMovies(
        @Query("api_key") apiKey: String
    ): Call<MovieResponse>
}