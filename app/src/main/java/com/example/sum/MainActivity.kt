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
            val num1 = num1EditText.text.toString().toDoubleOrNull() ?: 0.0
            val num2 = num2EditText.text.toString().toDoubleOrNull() ?: 0.0
            val sum = num1 + num2
            answer.text = "Result: $sum"
        }
    }
}