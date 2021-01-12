package com.example.sqllitetask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        var intent = intent
        val numberr1 = intent.getIntExtra("number1", 0)
        val numberr2 = intent.getIntExtra("number2", 0)
        val resval = intent.getIntExtra("resval", 0)
        var result = findViewById<TextView>(R.id.result)

        val resp = numberr1 + numberr2
        val resm = numberr1 - numberr2
        val resr = numberr1 * numberr2
        val resd = numberr1 / numberr2


        result.text = " " + numberr1 + " + " + numberr2 + " = " + resp + "\n" +
                " " + numberr1 + " - " + numberr2 + " = " + resm + "\n" +
                " " + numberr1 + " * " + numberr2 + " = " + resr + "\n" +
                " " + numberr1 + " / " + numberr2 + " = " + resd + "\n" +
                "Zwracanie i Wyświetlanie: " + resval

        handleBack()
    }

    fun handleBack(){
        val button_backCalc = findViewById<Button>(R.id.button_backCalc)
        button_backCalc.setOnClickListener(){
            val intent = Intent(this, CalculationActivity::class.java)
            startActivity(intent)
        }
    }
}