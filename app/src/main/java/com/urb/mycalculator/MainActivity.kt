package com.urb.mycalculator

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val ADDITION = '+'
    private val SUBTRACTION = '-'
    private val MULTIPLICATION = '*'
    private val DIVISION = '/'
    private val PERCENT = '%'
    private var currentSymbol = 0.toChar()
    private var firstValue = 0.0
    private var secondValue = 0.0

    lateinit var inputDisplay: TextView
    lateinit  var outputDisplay:TextView
    lateinit var button0: Button
    lateinit  var button1:Button
    lateinit  var button2:Button
    lateinit  var button3:Button
    lateinit  var button4:Button
    lateinit  var button5:Button
    lateinit  var button6:Button
    lateinit  var button7:Button
    lateinit  var button8:Button
    lateinit  var button9:Button
    lateinit var buttonDot: Button
    lateinit  var buttonAdd:Button
    lateinit  var buttonSub:Button
    lateinit  var buttonMultiply:Button
    lateinit  var buttonDivide:Button
    lateinit  var buttonPercent:Button
    lateinit  var buttonClear:Button
    lateinit  var buttonOFF:Button
    lateinit  var buttonEqual:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val decimalFormat = DecimalFormat("#,###.##")

        inputDisplay = findViewById(R.id.solution_tv);
        outputDisplay = findViewById(R.id.result_tv);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonAdd = findViewById(R.id.button_plus);
        buttonSub = findViewById(R.id.button_minus);
        buttonDivide = findViewById(R.id.button_divide);
        buttonDot = findViewById(R.id.button_dot);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonClear = findViewById(R.id.button_c);
        buttonOFF = findViewById(R.id.button_ac);
        buttonEqual = findViewById(R.id.button_equals);
        buttonPercent = findViewById(R.id.button_mod);


        button0.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "0"
            ) }
        button1.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "1"
            )

        }

        button2.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "2"
            )

        }

        button3.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "3"
            )
        }
        button4.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "4"
            )
        }
        button5.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "5"
            )
        }

        button6.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "6"
            )
        }

        button7.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "7"
            )
        }

        button8.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "8"
            )
        }

        button9.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "9"
            )
        }
        buttonAdd.setOnClickListener {
            firstValue= inputDisplay.text.toString().toDouble()
            currentSymbol = ADDITION
            outputDisplay.setText((firstValue).toString() + "+")
            inputDisplay.setText(null)
        }
        buttonSub.setOnClickListener {
            firstValue= inputDisplay.text.toString().toDouble()
            currentSymbol = SUBTRACTION
            outputDisplay.setText((firstValue).toString() + "-")
            inputDisplay.setText(null)
        }

        buttonMultiply.setOnClickListener {
            firstValue= inputDisplay.text.toString().toDouble()
            currentSymbol = MULTIPLICATION
            outputDisplay.setText((firstValue).toString() + "x")
            inputDisplay.setText(null)
        }

        buttonDivide.setOnClickListener {
            firstValue= inputDisplay.text.toString().toDouble()
            currentSymbol = DIVISION
            outputDisplay.setText((firstValue).toString() + "/")
            inputDisplay.setText(null)
        }
        buttonPercent.setOnClickListener {
            firstValue= inputDisplay.text.toString().toDouble()
            currentSymbol = PERCENT
            outputDisplay.setText((firstValue).toString() + "%")
            inputDisplay.setText(null)
        }

        buttonDot.setOnClickListener {
            inputDisplay.setText(
                inputDisplay.getText().toString() + "."
            )
        }

        buttonClear.setOnClickListener {
            if (inputDisplay.getText().length > 0) {
                val currentText = inputDisplay.getText()
                inputDisplay.setText(currentText.subSequence(0, currentText.length - 1))
            } else {
                firstValue = 0.0
                secondValue = 0.0
                inputDisplay.setText("")
                outputDisplay.setText("")
            }
        }

        buttonOFF.setOnClickListener {
            firstValue = 0.0
            secondValue = 0.0
            inputDisplay.setText("")
            outputDisplay.setText("")
        }

        buttonEqual.setOnClickListener {

            allCalculations()
            outputDisplay.setText(decimalFormat!!.format(firstValue))
            firstValue = 0.0
            currentSymbol = '0'
        }
    }


    private fun allCalculations() {

        if (firstValue != null) {
            secondValue = inputDisplay.text.toString().toDouble()
            inputDisplay.setText(null)
            if (currentSymbol == ADDITION) firstValue =
                (firstValue.toDouble() + secondValue.toDouble())
            else if (currentSymbol == SUBTRACTION) firstValue =
                firstValue - secondValue
            else if (currentSymbol == MULTIPLICATION) firstValue =
                firstValue * secondValue
            else if (currentSymbol == DIVISION) firstValue =
                firstValue / secondValue
            else if (currentSymbol == PERCENT) firstValue =
                firstValue % secondValue

        } else {
            try {
                firstValue = (inputDisplay.getText().toString()).toDouble()
            } catch (e: Exception) {
                outputDisplay.setText("error")
            }

        }
    }
}





