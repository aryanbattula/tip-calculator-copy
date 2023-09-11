package com.example.kotlin_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var meal_1: EditText
    private lateinit var meal_2: EditText
    private lateinit var meal_3: EditText
    private lateinit var tip_percent: EditText
    private lateinit var final_total: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById(R.id.button) as Button

        meal_1 = findViewById(R.id.Meal_1)
        meal_2 = findViewById(R.id.Meal_2)
        meal_3 = findViewById(R.id.Meal_3)
        final_total = findViewById(R.id.Total_Amount)
        tip_percent = findViewById(R.id.Tip_Percent)


        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val price_1 = meal_1.text.toString().toDoubleOrNull() ?: 0.0
                val price_2 = meal_2.text.toString().toDoubleOrNull() ?: 0.0
                val price_3 = meal_3.text.toString().toDoubleOrNull() ?: 0.0
                val tipNumber = tip_percent.text.toString().toDoubleOrNull() ?: 0.0

                val tipDecimal = tipNumber/100

                val totalCost = price_1 + price_2 + price_3
                val newTotalCost = (tipDecimal * totalCost) + totalCost

                val percentOne = price_1/totalCost
                val totalOne = percentOne * newTotalCost

                val percentTwo = price_2/totalCost
                val totalTwo = percentTwo * newTotalCost

                val percentThree = price_3/totalCost
                val totalThree = percentThree * newTotalCost

                val meal1output = findViewById<TextView>(R.id.meal1output)
                meal1output.text = "Meal 1: ${"%.2f".format(totalOne)}"

                val meal2output = findViewById<TextView>(R.id.meal2output)
                meal2output.text = "Meal 2: ${"%.2f".format(totalTwo)}"

                val meal3output = findViewById<TextView>(R.id.meal3output)
                meal3output.text = "Meal 3: ${"%.2f".format(totalThree)}"

                final_total.text = "${"%.2f".format(newTotalCost)}"

            }
        })
    }
}
