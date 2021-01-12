package com.example.sqllitetask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CalculationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        handleCalculation()
        handleBack()

    }

    fun handleBack(){
        val button_backCalculation = findViewById<Button>(R.id.button_backCalculation)
        button_backCalculation.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun handleCalculation(){

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)



        val button_calc = findViewById<Button>(R.id.button_calc)

        button_calc.setOnClickListener(){
                val number1p = Integer.parseInt(number1.getText().toString())
                val number2p = Integer.parseInt(number2.getText().toString())
                val resval = pushData(number1p)
                val intent = Intent(this, CalcActivity::class.java)
                intent.putExtra("number1", number1p)
                intent.putExtra("number2", number2p)
                intent.putExtra("resval", resval)
                startActivity(intent)

        }
    }

        fun pushData(number: Int) : Int{
            return number
        }

}