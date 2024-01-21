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
        helloButton.text="Question"
        additionalButton.text="Answer"
        Log.i("info","hello world soft coded in the textview")

        val changeFunction: () -> Unit = {
            greetingTextView.text = if (greetingTextView.text == "Hello how are you?") "How is your day going?"
            else "Hello how are you?"
            Log.i("info", "Change button clicked")
        }

        val additionalFunction: () -> Unit = {
            greetingTextView.text = if (greetingTextView.text == "I'm fine")
                "Day is going better"
            else
                "I'm fine"
            Log.i("info", "Additional button clicked")
        }

        // Assign functions to buttons
        helloButton.setOnClickListener { changeFunction.invoke() }
        additionalButton.setOnClickListener { additionalFunction.invoke() }
    }

}