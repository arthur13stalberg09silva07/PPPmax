package com.example.pppmax.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel() {
    private val _selectedMovieId = MutableLiveData<String>()

    val selectedMovieId: LiveData<String>
        get() = _selectedMovieId

    fun setSelectedMovieId(movieId: String) {
        _selectedMovieId.value = movieId
    }
}