package com.example.sum

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val num1EditText = findViewById<EditText>(R.id.editTextNumberDecimal)
        val num2EditText = findViewById<EditText>(R.id.editTextNumberDecimal2)
        val addButton = findViewById<Button>(R.id.button)
        val answer = findViewById<TextView>(R.id.textView2)

        addButton.setOnClickListener {
            val num1T = num1EditText.text.toString()
            val num2T = num2EditText.text.toString()

            var num1: Double? = null
            var num2: Double? = null
            var hasError = false

            if (num1T.isBlank()) {
                    num1EditText.error = "Please Enter a Number"
                    hasError = true
                } else {
                    try {
                        num1 = num1T.toDouble()
                    } catch (e: NumberFormatException) {

                        num1EditText.error = "Invalid format"
                        hasError = true
                    }
                }
            if (num2T.isBlank()) {
                    num2EditText.error = "Please Enter a Number"
                    hasError = true
                } else {
                    try {
                        num2 = num2T.toDouble()
                    } catch (e: NumberFormatException) {

                        num2EditText.error = "Invalid format"
                        hasError = true
                    }
                }
            if (!hasError) {

                    val sum = num1!! + num2!!
                    answer.text = "Result: $sum"
                } else {
                    answer.text = "Please Enter Numbers "
                }
            }
        }
    }
