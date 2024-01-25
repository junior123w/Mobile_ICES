package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.clearButton.setOnClickListener { view -> processOperatorButtons(view) }
        binding.percentButton.setOnClickListener { view -> processOperatorButtons(view) }
    }

    private fun processOperatorButtons(view: View) {
        val resultTextView=findViewById<TextView>(R.id.resultTextView)
        resultTextView.text=view.tag.toString()
        Log.i("operators",view.tag.toString())

    }

}