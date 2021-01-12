package com.example.sqllitetask

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InsertActivity : AppCompatActivity() {

    internal var dbHelper = DatabaseHelper(this)

    fun showToast(text: String) {
        Toast.makeText(this@InsertActivity, text, Toast.LENGTH_LONG).show()
    }

    fun showDialog(title: String, Message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        handleInserts()
        handleBack()
    }

fun clearEditTexts() {
        val nameTextInsert = findViewById<EditText>(R.id.nameTextInsert)
        val emailTextInsert = findViewById<EditText>(R.id.emailTextInsert)
        val yearTextInsert = findViewById<EditText>(R.id.yearTextInsert)
        nameTextInsert.setText("")
        emailTextInsert.setText("")
        yearTextInsert.setText("")

}
    fun handleInserts() {
        val button_insertInsert = findViewById<Button>(R.id.button_insertInsert)
        val nameTextInsert = findViewById<EditText>(R.id.nameTextInsert)
        val emailTextInsert = findViewById<EditText>(R.id.emailTextInsert)
        val yearTextInsert = findViewById<EditText>(R.id.yearTextInsert)

        button_insertInsert.setOnClickListener {
            try {
                dbHelper.insertData(nameTextInsert.text.toString(), emailTextInsert.text.toString(),
                    yearTextInsert.text.toString())
                clearEditTexts()
            } catch (e: Exception) {
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleBack(){
        val button_backInsert = findViewById<Button>(R.id.button_backInsert)
        button_backInsert.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}