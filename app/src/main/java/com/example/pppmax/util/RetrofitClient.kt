package com.example.pppmax.util;


import com.example.teste2api.MovieApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitClient {

    companion object{
        private const val baseUrl = "https://api.themoviedb.org/3/"
        fun getMovie ():MovieApi {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApi::class.java)
        }
    }

}
