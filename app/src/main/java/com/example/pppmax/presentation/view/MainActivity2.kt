package com.example.pppmax.presentation.view


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pppmax.R
import com.example.pppmax.databinding.ActivityMain2Binding
import com.example.pppmax.presentation.adapter.MovieAdapter
import com.example.pppmax.presentation.viewmodel.MovieViewModel
import com.example.pppmax.presentation.viewmodel.MovieViewModelFactory

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras

        if (extras != null) {
            val movieId = extras.getString("movieId")

            recyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            movieAdapter = MovieAdapter()
            recyclerView.adapter = movieAdapter

            var viewModel = ViewModelProvider(this, MovieViewModelFactory())
                .get(MovieViewModel::class.java)

            viewModel.getMovieById("550")

            viewModel.movieLiveData.observe(this) {
                Log.d("banana", it.toString())
                movieAdapter.setMovies(listOf(it))
            }


            binding.buttonVoltar.setOnClickListener {
                finish()
            }
        } else {
            Log.e("MovieList", "Extras não encontrados no Intent.")
            finish()
        }
    }
    //       testar codigo 872585
}