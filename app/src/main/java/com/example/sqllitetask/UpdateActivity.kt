package com.example.sqllitetask

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateActivity : AppCompatActivity() {

    internal var dbHelper = DatabaseHelper(this)

    fun showToast(text: String) {
        Toast.makeText(this@UpdateActivity, text, Toast.LENGTH_LONG).show()
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
        setContentView(R.layout.activity_update)

        handleUpdate()
        handleBack()
    }

    fun  handleUpdate(){

        val idTextUpdate = findViewById<EditText>(R.id.idTextUpdate)
        val nameTextUpdate = findViewById<EditText>(R.id.nameTextUpdate)
        val emailTextUpdate = findViewById<EditText>(R.id.emailTextUpdate)
        val yearTextUpdate = findViewById<EditText>(R.id.yearTextUpdate)

        val button_updateUpdate = findViewById<Button>(R.id.button_updateUpdate)

        button_updateUpdate.setOnClickListener {
            try {
                val isUpdate = dbHelper.updateData(
                    idTextUpdate.text.toString(), nameTextUpdate.text.toString(),
                    emailTextUpdate.text.toString(), yearTextUpdate.text.toString()
                )
                if (isUpdate == true)
                    showToast("Data Updated Successfully")
                else
                    showToast("Data not Updated")
            } catch (e: Exception) {
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
    }

    fun handleBack(){
        val button_backUpdate = findViewById<Button>(R.id.button_backUpdate)
        button_backUpdate.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}