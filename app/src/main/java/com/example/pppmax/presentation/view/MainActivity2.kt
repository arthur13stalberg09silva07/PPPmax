package com.example.pppmax.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pppmax.R
import com.example.pppmax.databinding.ActivityMain2Binding
import com.example.pppmax.domain.model.Movie
import com.example.pppmax.presentation.adapter.MovieAdapter
import com.example.teste2api.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var movieAdapter: MovieAdapter

    private var movieID = "550"
    private val apiKey = "14d85696826338f3be7b526bcea0ea65"
    private val baseUrl = "https://api.themoviedb.org/3/"
    private val language = "pt-BR"

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

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val movieApi = retrofit.create(MovieApi::class.java)
//            movieApi.getMovie(movieID, apiKey, language)
            val call = movieApi.getMovie(movieID,apiKey,language)
            call.enqueue(object : Callback<Movie> {
                override fun onResponse(
                    call: Call<Movie>,
                    response: Response<Movie>
                ) {
                    if (response.isSuccessful) {
                        val movieResponse = response.body()
                        if (movieResponse != null) {
                            if (::movieAdapter.isInitialized) {
                                movieAdapter.setMovies(listOf(movieResponse))
                            } else {
                                Log.e("MovieList", "movieAdapter não foi inicializado.")
                            }
                        }
                    } else {
                        Log.e("MovieList", "Erro na resposta da API: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.e("MovieList", "Erro na chamada da API: ${t.message}")
                }
            })

            binding.buttonVoltar.setOnClickListener {
                finish()
            }
        } else {
            Log.e("MovieList", "Extras não encontrados no Intent.")
            finish() // Terminar a atividade se não houver extras
        }
    }
    //       testar codigo 872585
}