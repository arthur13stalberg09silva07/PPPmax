package com.example.pppmax.util

import com.example.pppmax.presentation.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PPPmodule = module {
    viewModel {
        MovieViewModel(get())
    }
}