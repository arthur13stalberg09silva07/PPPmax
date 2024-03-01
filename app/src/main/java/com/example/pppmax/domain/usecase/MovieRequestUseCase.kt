package com.example.pppmax.domain.usecase

import android.util.Log
import com.example.pppmax.data.api.MovieApi
import com.example.pppmax.data.repository.MovieRepositoryImpl
import com.example.pppmax.domain.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieRequestUseCase (private val api: MovieApi) {

    private val TAG = "Api Requests"
    private val scope = CoroutineScope( Dispatchers.Main)
    private val errorMovie = Movie("????",
        "Missing.",
        "Missing.",
        "https://wallpapercave.com/wp/wp7002078.png",
        )

    fun getMovieById(id: String, callback: (Movie) -> Unit) {
        Log.d(TAG, "getMovieById")
        scope.launch{
            MovieRepositoryImpl(api).getMovieById(id)
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.d(TAG, "Error in getMovieById: "+it)
                    withContext(Dispatchers.Main){
                        callback(errorMovie)
                    }
                }
                .collect {
                    Log.d(TAG, "getMovieById: ${it.title}")
                    withContext(Dispatchers.Main){
                        callback(it)
                    }
                }

        }
        Log.d(TAG, "getMovieById Fineshed")
    }
}
