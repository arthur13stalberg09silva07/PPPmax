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

        binding.buttonPesquisar.setOnClickListener{
            val movieId = binding.editId.text.toString()
            Log.d("MovieID", "Movie ID: $movieId")

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("movieId", movieId)
            startActivity(intent)
        }
    }
}