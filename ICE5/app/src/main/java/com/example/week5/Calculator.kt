package com.example.week5

import android.view.View
import com.example.week5.databinding.ActivityMainBinding

class Calculator(binding: ActivityMainBinding)
{
    private var m_binding: ActivityMainBinding
    private var m_resultLabelValue : String
    
    init{
        this.m_binding=binding
        this.m_resultLabelValue = ""
        initializeOnCLickListener()
    }


    private fun initializeOnCLickListener() {
        //operator buttons
        this.m_binding.divideButton.setOnClickListener { view -> processOperatorButtons(view) }
        this.m_binding.addButton.setOnClickListener { view -> processOperatorButtons(view) }
        this.m_binding.subtractButton.setOnClickListener { view -> processOperatorButtons(view) }
        this.m_binding.equalButton.setOnClickListener { view -> processOperatorButtons(view) }
        this.m_binding.multiplyButton.setOnClickListener { view -> processOperatorButtons(view) }

        //extra buttons
        this.m_binding.plusMinusButton.setOnClickListener { view -> processExtraButtons(view) }
        this.m_binding.clearButton.setOnClickListener { view -> processExtraButtons(view) }
        this.m_binding.percentButton.setOnClickListener { view -> processExtraButtons(view) }
        this.m_binding.backSpaceButton.setOnClickListener { view -> processExtraButtons(view) }

        //number buttons
        this.m_binding.nineButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.eightButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.sevenButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.sixButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.fiveButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.fourButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.thirdButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.twoButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.oneButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.zeroButton.setOnClickListener { view -> processNumberButtons(view) }
        this.m_binding.decimalButton.setOnClickListener { view -> processNumberButtons(view) }
    }

    //shared event handlers
    private fun processOperatorButtons(view: View) {

    }


    private fun processExtraButtons(view: View) {
        when (view)
        {
            this.m_binding.clearButton ->{
                m_resultLabelValue = "0"
                this.m_binding.resultTextView.text = m_resultLabelValue
            }

            this.m_binding.backSpaceButton -> {
                if (m_resultLabelValue.isNotEmpty()) {
                    m_resultLabelValue =
                        m_resultLabelValue.substring(0, m_resultLabelValue.length - 1)
                    this.m_binding.resultTextView.text =
                        if (m_resultLabelValue.isNotEmpty()) { m_resultLabelValue} else {"0"}
                }
            }

            this.m_binding.plusMinusButton ->{
                if (m_resultLabelValue.isNotEmpty() && m_resultLabelValue != "0") {
                    m_resultLabelValue = if (m_resultLabelValue[0] == '-') {
                        m_resultLabelValue.substring(1)
                    } else {
                        "-$m_resultLabelValue"
                    }
                    this.m_binding.resultTextView.text = m_resultLabelValue
                }
            }
        }
    }


    private fun processNumberButtons(view: View)
    {
        val buttonValue= view.tag.toString()

        if (m_resultLabelValue == "0") {
            m_resultLabelValue = buttonValue
        } else {
            if (view.tag.toString() == ".") {
                if (!m_resultLabelValue.contains(".")) {
                    m_resultLabelValue += view.tag.toString()
                }
            } else {
                m_resultLabelValue += view.tag.toString()

            }
        }
        this.m_binding.resultTextView.text= m_resultLabelValue

    }
}
