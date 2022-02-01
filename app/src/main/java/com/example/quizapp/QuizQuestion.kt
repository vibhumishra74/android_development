package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestion : AppCompatActivity(), View.OnClickListener {

     var questionList = constant.getQuestion()
     var currentPosition:Int = 1
    var selectedOptionPosition :Int = 0
    var correctabswer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

//        Log.i("QUESTION Size","${questionList.size}")

        var optionone: TextView = findViewById<TextView>(R.id.tc_option_one)
        var optiontwo:TextView = findViewById<TextView>(R.id.tc_option_two)
        var optionthree:TextView = findViewById<TextView>(R.id.tc_option_three)
        var optionfour:TextView = findViewById<TextView>(R.id.tc_option_four)
        var submitbtn:Button = findViewById<Button>(R.id.submit_btn)

        setQuestion()

        optionone.setOnClickListener(this)
        optiontwo.setOnClickListener(this)
        optionthree.setOnClickListener(this)
        optionfour.setOnClickListener(this)
        submitbtn.setOnClickListener(this)
//        if(submitbtn.text=="Result"){
//            var intent = Intent(this,result::class.java)
//            startActivity(intent)
//        }
    }


    private fun setQuestion(){
    var progressBar: ProgressBar = findViewById<ProgressBar>(R.id.progressBar)
    var progressBarText: TextView = findViewById<TextView>(R.id.progressBar_text)
    var questionHeading: TextView = findViewById<TextView>(R.id.tv_questionHeading)
    var image: ImageView = findViewById<ImageView>(R.id.iv_image)
    var optionone: TextView = findViewById<TextView>(R.id.tc_option_one)
    var optontwo:TextView = findViewById<TextView>(R.id.tc_option_two)
    var optonthree:TextView = findViewById<TextView>(R.id.tc_option_three)
    var optonfour:TextView = findViewById<TextView>(R.id.tc_option_four)
        var submitbtn:Button = findViewById<Button>(R.id.submit_btn)

        var question:Question? = questionList[currentPosition - 1]

        defaultOptionView()
        if(currentPosition == questionList!!.size){
            submitbtn.text = "Result"
        }else{
            submitbtn.text = "Submit"
        }
        progressBar.progress = currentPosition // setting progress value
        progressBar.max = questionList.size // setting max value
        progressBarText.text = "${currentPosition}/${progressBar.max}"
        questionHeading.text = question!!.question
        //image set
        image.setImageResource(question.image)
        //option set
        optionone.text = question.optionOne
        optontwo.text = question.optionTwo
        optonthree.text = question.optionThree
        optonfour.text = question.optionFour
    }

    private fun defaultOptionView(){
        var optionone: TextView = findViewById<TextView>(R.id.tc_option_one)
        var optiontwo:TextView = findViewById<TextView>(R.id.tc_option_two)
        var optionthree:TextView = findViewById<TextView>(R.id.tc_option_three)
        var optionfour:TextView = findViewById<TextView>(R.id.tc_option_four)

        val options = ArrayList<TextView>()
        options.add(0,optionone)
        options.add(1,optiontwo)
        options.add(2,optionthree)
        options.add(3,optionfour)
        for (option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(p0: View?) {
        var optionOne: TextView = findViewById<TextView>(R.id.tc_option_one)
        var optiontwo:TextView = findViewById<TextView>(R.id.tc_option_two)
        var optionthree:TextView = findViewById<TextView>(R.id.tc_option_three)
        var optionfour:TextView = findViewById<TextView>(R.id.tc_option_four)
        var submitbtn:Button = findViewById<Button>(R.id.submit_btn)

        when(p0?.id){
            R.id.tc_option_one ->{
                selectedOptionView(optionOne,1)
            }
            R.id.tc_option_two ->{
                selectedOptionView(optiontwo,2)
            }
            R.id.tc_option_three->{
                selectedOptionView(optionthree,3)
            }
            R.id.tc_option_four->{
                selectedOptionView(optionfour,4)
            }
            R.id.submit_btn->{
                if(selectedOptionPosition == 0){
                    currentPosition++
                    when{
                        currentPosition <= questionList!!.size ->{
                            setQuestion()
                        }else ->{
//                        Toast.makeText(this, "you have completed the Quiz",
//                            Toast.LENGTH_SHORT).show()
                        var intent = Intent(this,result::class.java)
                        intent.putExtra("correctness",correctabswer.toString())
                        intent.putExtra("total_question",questionList!!.size)
                        startActivity(intent)
                        }
                    }
                }else{
//                    var question:Question? = questionList[currentPosition - 1]
                    val questionLocal:Question = questionList?.get(currentPosition-1)
                    if(questionLocal!!.correctAnswer != selectedOptionPosition){
                    answerView(selectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        correctabswer++
                    }
                    answerView(questionLocal!!.correctAnswer,R.drawable.correct_option_border_bg)

                    if(currentPosition == questionList!!.size){
                        submitbtn.text = "FINISH"
                    }else{
                        submitbtn.text = "GO TO NEXT QUESTION"
                    }
                    selectedOptionPosition = 0
                    Log.i("current position","current position $currentPosition ," +
                            " correct answer ${questionLocal!!.correctAnswer} and selected position $selectedOptionPosition true or false " +
                            "${questionLocal!!.correctAnswer != selectedOptionPosition}")
                }

            }
        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        var optionone: TextView = findViewById<TextView>(R.id.tc_option_one)
        var optiontwo:TextView = findViewById<TextView>(R.id.tc_option_two)
        var optionthree:TextView = findViewById<TextView>(R.id.tc_option_three)
        var optionfour:TextView = findViewById<TextView>(R.id.tc_option_four)
        when(answer){
            1->{optionone.background = ContextCompat.getDrawable(this,drawableView)}
            2->{optiontwo.background = ContextCompat.getDrawable(this,drawableView)}
            3->{optionthree.background = ContextCompat.getDrawable(this,drawableView)}
            4->{optionfour.background = ContextCompat.getDrawable(this,drawableView)}
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOption:Int){
        defaultOptionView()
        selectedOptionPosition = selectedOption
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border)
    }
}
