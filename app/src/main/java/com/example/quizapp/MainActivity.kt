package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     var editName = findViewById<AppCompatEditText>(R.id.et_name)
    var startButtons = findViewById<Button>(R.id.btn_start)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

            startButtons.setOnClickListener{
        if(editName.text.toString().isEmpty()){
            Toast.makeText(this, "Please enter your Name", Toast.LENGTH_SHORT).show()
            }else{
            username.user_name = editName.text.toString()
                val intent = Intent(this,QuizQuestion::class.java)
            startActivity(intent)
            finish()
        }
        }
    }
}