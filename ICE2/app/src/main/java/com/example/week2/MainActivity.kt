package com.example.week2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.greetingTextView)
        val helloButton = findViewById<Button>(R.id.change)
        val additionalButton = findViewById<Button>(R.id.change2)
        greetingTextView.text = "Hello, World"
        Log.i("info","hello world soft coded in the textview")

        val changeFunction: () -> Unit = {
            greetingTextView.text = if (greetingTextView.text == "Hello, World") "GoodBye , World"
            else "Hello, World"
            Log.i("info", "Change button clicked")
        }

        val additionalFunction: () -> Unit = {
            greetingTextView.text = if (greetingTextView.text == "Additional Button Clicked")
                "Welcome Back!"
            else
                "Additional Button Clicked"
            Log.i("info", "Additional button clicked")
        }

        // Assign functions to buttons
        helloButton.setOnClickListener { changeFunction.invoke() }
        additionalButton.setOnClickListener { additionalFunction.invoke() }
    }

}