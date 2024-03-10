package com.example.week08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week08.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Declare an instance of the binding class
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the list of TVShows from DataManager
        val tvShows = DataManager.instance.deserializeJSON(this)

        // Check if tvShows is not null before displaying
        if (tvShows != null) {
            // Display the TVShows in the RecyclerView
            val firstAdapter = FirstAdapter(tvShows)

            binding.FirstRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = firstAdapter
            }
        }
    }
}
