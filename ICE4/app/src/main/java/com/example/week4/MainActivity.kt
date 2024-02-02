package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeOnCLickListener()
    }

    private fun initializeOnCLickListener() {
        //operator buttons
        binding.divideButton.setOnClickListener { view -> processOperatorButtons(view) }
        binding.addButton.setOnClickListener { view -> processOperatorButtons(view) }
        binding.subtractButton.setOnClickListener { view -> processOperatorButtons(view) }
        binding.equalButton.setOnClickListener { view -> processOperatorButtons(view) }
        binding.multiplyButton.setOnClickListener { view -> processOperatorButtons(view) }

        //extra buttons
        binding.plusMinusButton.setOnClickListener { view -> processExtraButtons(view) }
        binding.clearButton.setOnClickListener { view -> processExtraButtons(view) }
        binding.percentButton.setOnClickListener { view -> processExtraButtons(view) }
        binding.backSpaceButton.setOnClickListener { view -> processExtraButtons(view) }

        //number buttons
        binding.nineButton.setOnClickListener { view -> numberButtons(view) }
        binding.eightButton.setOnClickListener { view -> numberButtons(view) }
        binding.sevenButton.setOnClickListener { view -> numberButtons(view) }
        binding.sixButton.setOnClickListener { view -> numberButtons(view) }
        binding.fiveButton.setOnClickListener { view -> numberButtons(view) }
        binding.fourButton.setOnClickListener { view -> numberButtons(view) }
        binding.thirdButton.setOnClickListener { view -> numberButtons(view) }
        binding.twoButton.setOnClickListener { view -> numberButtons(view) }
        binding.oneButton.setOnClickListener { view -> numberButtons(view) }
        binding.zeroButton.setOnClickListener { view -> numberButtons(view) }
        binding.decimalButton.setOnClickListener { view -> numberButtons(view) }
    }

    //shared event handlers
    private fun processOperatorButtons(view: View) {
       binding.resultTextView.text=view.tag.toString()
    }

    private fun processExtraButtons(view:View){

    }

    private fun numberButtons(view: View) {
        binding.resultTextView.text=view.tag.toString()
    }

}