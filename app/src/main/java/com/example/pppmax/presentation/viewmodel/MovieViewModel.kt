package com.example.pppmax.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pppmax.domain.model.Movie
import com.example.pppmax.domain.usecase.MovieRequestUseCase

class MovieViewModel(private val movieRequestUseCase: MovieRequestUseCase) : ViewModel() {

    var movieLiveData= MutableLiveData<Movie>()

    fun getMovieById(id:String){

        movieRequestUseCase.getMovieById(id){ response ->
            movieLiveData.value = response
        }
    }

}