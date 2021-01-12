package com.example.sqllitetask

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class ViewActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view)
//    }

    internal var dbHelper = DatabaseHelper(this)

    fun showToast(text: String) {
        Toast.makeText(this@ViewActivity, text, Toast.LENGTH_LONG).show()
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
        setContentView(R.layout.activity_view)

        handleViewing()
        handleBack()
    }

    fun handleViewing() {
        val button_viewView = findViewById<Button>(R.id.button_viewView)
        button_viewView.setOnClickListener(
            View.OnClickListener {
                val res = dbHelper.allData
                if (res.count == 0) {
                    showDialog("Error", "No Data Found")
                    return@OnClickListener
                }

                val buffer = StringBuffer()
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n")
                    buffer.append("Name :" + res.getString(1) + "\n")
                    buffer.append("Email :" + res.getString(2) + "\n")
                    buffer.append("Year :" + res.getString(3) + "\n\n")
                }
                showDialog("Data Listing", buffer.toString())
            }
        )
    }


    fun handleBack() {
        val button_backView = findViewById<Button>(R.id.button_backView)
        button_backView.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}