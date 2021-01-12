package com.example.sqllitetask

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()
        handleCalc()
    }

    fun handleInserts() {
        val button_insert = findViewById<Button>(R.id.button_insertOption)
        button_insert.setOnClickListener(){
            val intent = Intent(this, InsertActivity::class.java)
            startActivity(intent)
        }
    }



    fun handleUpdates() {
        val button_update = findViewById<Button>(R.id.button_updateOption)
        button_update.setOnClickListener{
        val intent = Intent(this, UpdateActivity::class.java)
        startActivity(intent)
        }
    }



    fun handleDeletes() {
        val button_delete = findViewById<Button>(R.id.button_deleteOption)
        button_delete.setOnClickListener(){
            val intent = Intent(this, DeleteActivity::class.java)
            startActivity(intent)
        }
    }

    fun handleViewing() {
        val button_view = findViewById<Button>(R.id.button_viewOption)
        button_view.setOnClickListener(){
            val intent = Intent(this, ViewActivity::class.java)
            startActivity(intent)
        }
    }

    fun handleCalc() {
        val button_CalculationOption = findViewById<Button>(R.id.button_CalculationOption)
        button_CalculationOption.setOnClickListener(){
            val intent = Intent(this, CalculationActivity::class.java)
            startActivity(intent)
        }
    }

}