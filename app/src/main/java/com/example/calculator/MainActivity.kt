package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    var digit_on_screen = StringBuilder()
    var operation: Char = ' '
    var leftHandSide: Double = 0.0
    var rightHandSide: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.Result).text = "0"
        initializeButtons()
    }
    private fun initializeButtons() {
        functionalButtons()
        operationalButtons()
        numericalButtons()
    }
    private fun numericalButtons()
    {
        findViewById<Button>(R.id.One).setOnClickListener {
            appendToDigitOnScreen("1")
        }
        findViewById<Button>(R.id.Two).setOnClickListener {
            appendToDigitOnScreen("2")
        }
        findViewById<Button>(R.id.Three).setOnClickListener {
            appendToDigitOnScreen("3")
        }
        findViewById<Button>(R.id.Four).setOnClickListener {
            appendToDigitOnScreen("4")
        }
        findViewById<Button>(R.id.Five).setOnClickListener {
            appendToDigitOnScreen("5")
        }
        findViewById<Button>(R.id.Six).setOnClickListener {
            appendToDigitOnScreen("6")
        }
        findViewById<Button>(R.id.Seven).setOnClickListener {
            appendToDigitOnScreen("7")
        }
        findViewById<Button>(R.id.Eight).setOnClickListener {
            appendToDigitOnScreen("8")
        }
        findViewById<Button>(R.id.Nine).setOnClickListener {
            appendToDigitOnScreen("9")
        }
        findViewById<Button>(R.id.Zero).setOnClickListener {
            appendToDigitOnScreen("0")
        }
        findViewById<Button>(R.id.Dot).setOnClickListener {
            appendToDigitOnScreen(".")
        }
    }
    private fun appendToDigitOnScreen(digit: String) {
        digit_on_screen.append(digit)
        findViewById<TextView>(R.id.Result).text = digit_on_screen.toString()
    }
    private fun operationalButtons()
    {
        findViewById<Button>(R.id.Add).setOnClickListener {
            selectOperation('A')
        }
        findViewById<Button>(R.id.Minus).setOnClickListener {
            selectOperation('S')
        }
        findViewById<Button>(R.id.Multiplication).setOnClickListener {
            selectOperation('M')
        }
        findViewById<Button>(R.id.Divide).setOnClickListener {
            selectOperation('D')
        }
    }
    private fun selectOperation(c: Char) {

        operation = c
        leftHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()
        findViewById<TextView>(R.id.Result).text = "0"
    }
    private fun functionalButtons(){
        findViewById<Button>(R.id.Clear).setOnClickListener {
            digit_on_screen.clear()
            findViewById<TextView>(R.id.Result).text = "0"
        }
        findViewById<Button>(R.id.Back).setOnClickListener {
            clearDigit()
        }
        findViewById<Button>(R.id.Equals).setOnClickListener {
            performMathOperation()
        }
    }
    private fun clearDigit() {

        val length = digit_on_screen.length

        digit_on_screen.deleteCharAt(length - 1)
        findViewById<TextView>(R.id.Result).text = digit_on_screen.toString()

    }
    private fun performMathOperation() {

        rightHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()

        when (operation) {

            'A' -> {
                val sum = OperationHelper.add(leftHandSide, rightHandSide)
                findViewById<TextView>(R.id.Result).text = sum.toString()
                digit_on_screen.append(sum)
            }
            'S' -> {
                val subtract = OperationHelper.subtract(leftHandSide, rightHandSide)
                findViewById<TextView>(R.id.Result).text  = subtract.toString()
                digit_on_screen.append(subtract)
            }
            'M' -> {
                val multiply = OperationHelper.multiply(leftHandSide, rightHandSide)
                findViewById<TextView>(R.id.Result).text  = multiply.toString()
                digit_on_screen.append(multiply)
            }
            'D' -> {
                val divide = OperationHelper.divide(leftHandSide, rightHandSide)
                findViewById<TextView>(R.id.Result).text  = divide.toString()
                digit_on_screen.append(divide)
            }

        }

    }


}