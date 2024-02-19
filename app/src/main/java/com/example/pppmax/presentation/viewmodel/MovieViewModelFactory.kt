package com.example.pppmax.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pppmax.domain.usecase.MovieRequestUseCase
import com.example.pppmax.util.RetrofitClient

class MovieViewModelFactory: ViewModelProvider.Factory {

    private val MovieRequestUseCase = MovieRequestUseCase(RetrofitClient.getMovie())
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(MovieRequestUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}