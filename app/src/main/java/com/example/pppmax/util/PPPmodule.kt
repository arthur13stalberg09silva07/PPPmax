package com.example.pppmax.util

import android.app.Application
import com.example.pppmax.presentation.viewmodel.MovieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

val PPPmodule = module {
    viewModel {
        MovieViewModel(get())

    }
}
    class MyApp : Application() {
        override fun onCreate() {
            super.onCreate()
            // Inicialize o Koin
            startKoin {
                androidContext(this@MyApp)
                modules(PPPmodule)
        }
    }
}