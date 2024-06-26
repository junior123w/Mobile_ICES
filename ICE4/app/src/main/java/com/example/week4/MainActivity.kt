package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var resultLabelValue: String = ""
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
        binding.nineButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.eightButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.sevenButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.sixButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.fiveButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.fourButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.thirdButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.twoButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.oneButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.zeroButton.setOnClickListener { view -> processNumberButtons(view) }
        binding.decimalButton.setOnClickListener { view -> processNumberButtons(view) }
    }

    //shared event handlers
    private fun processOperatorButtons(view: View) {

    }

    private fun processExtraButtons(view: View) {
        when (view)
        {
            binding.clearButton ->{
                resultLabelValue = "0"
                binding.resultTextView.text = resultLabelValue
            }

            binding.backSpaceButton ->{
                if (resultLabelValue.isNotEmpty()) {
                    resultLabelValue = resultLabelValue.substring(0, resultLabelValue.length - 1)
                    binding.resultTextView.text = resultLabelValue
                }
            }

            binding.plusMinusButton ->{
                if (resultLabelValue.isNotEmpty() && resultLabelValue != "0") {
                    if (resultLabelValue[0] == '-') {
                        resultLabelValue = resultLabelValue.substring(1)
                    } else {
                        resultLabelValue = "-$resultLabelValue"
                    }
                    binding.resultTextView.text = resultLabelValue
                }
            }
        }
    }


    private fun processNumberButtons(view: View)
    {
        val buttonValue= view.tag.toString()

        if (resultLabelValue == "0") {
            resultLabelValue = buttonValue
        } else {
            if (view.tag.toString() == ".") {
                if (!resultLabelValue.contains(".")) {
                    resultLabelValue += view.tag.toString()
                }
            } else {
                resultLabelValue += view.tag.toString()

            }
        }
        binding.resultTextView.text= resultLabelValue

    }

}
