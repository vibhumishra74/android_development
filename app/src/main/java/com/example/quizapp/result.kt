package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var score = findViewById<TextView>(R.id.score)
        var user_name = findViewById<TextView>(R.id.user_name)
        var result_finish_btn = findViewById<Button>(R.id.result_finish_btn)
        var get_score = intent.extras!!.getString("correctness")
        var total_question = intent.extras!!.getInt("total_question")
        score.text = "your Score is $get_score out of $total_question"
        user_name.text = username.user_name
        result_finish_btn.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}