package com.example.pppmax.presentation.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pppmax.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = binding.editId.text.toString()

        binding.buttonPesquisar.setOnClickListener{
            Log.d("MovieID", "Movie ID: $movieId")

            // Criar um Intent
            val intent = Intent(this, MainActivity2::class.java)

            // Adicionar dados extras ao Intent
            intent.putExtra("movieId", movieId)

            // Iniciar a MainActivity2 com o Intent
            startActivity(intent)
        }
    }
}