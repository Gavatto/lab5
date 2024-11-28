package com.example.lab5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Зв’язування елементів інтерфейсу
        val singleReliabilityInput = findViewById<EditText>(R.id.singleReliabilityInput)
        val doubleReliabilityInput = findViewById<EditText>(R.id.doubleReliabilityInput)
        val lossInput = findViewById<EditText>(R.id.lossInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        // Обробник натискання кнопки
        calculateButton.setOnClickListener {
            val singleReliability = singleReliabilityInput.text.toString().toDoubleOrNull() ?: 0.0
            val doubleReliability = doubleReliabilityInput.text.toString().toDoubleOrNull() ?: 0.0
            val loss = lossInput.text.toString().toDoubleOrNull() ?: 0.0

            val result = calculateReliabilityAndLoss(singleReliability, doubleReliability, loss)
            resultTextView.text = result
        }
    }

    // Функція для обчислень
    private fun calculateReliabilityAndLoss(
        singleReliability: Double,
        doubleReliability: Double,
        loss: Double
    ): String {
        // Порівняння надійності
        val reliabilityComparison = if (singleReliability > doubleReliability) {
            "Одноколова система надійніша."
        } else {
            "Двоколова система надійніша."
        }

        // Розрахунок збитків
        val lossResult = "Очікувані збитки: ${loss * (1 - singleReliability)} грн"

        return "$reliabilityComparison\n$lossResult"
    }
}