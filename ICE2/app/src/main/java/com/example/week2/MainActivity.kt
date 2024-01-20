package com.example.week2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingTextView = findViewById<TextView>(R.id.greetingTextView)
        greetingTextView.text="Hello, World"
        val allCapsButton = findViewById<Button>(R.id.change)

        allCapsButton.setOnClickListener{greetingTextView.text=if(greetingTextView.text == "Hello, World") "GoodBye , World"
        else "Hello, World"
        }
    }
}