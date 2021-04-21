package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionsList = Constants.getQuestions()
        Log.i("Questions Size", "${questionsList.size}")

        val currentPosition = 1

        val question: Question? = questionsList[currentPosition - 1]
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = currentPosition

        val tvProgress = findViewById<TextView>(R.id.tvProgress)
        tvProgress.text = "${currentPosition}/" + progressBar.max

        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        tvQuestion.text = question!!.question

        val ivImage = findViewById<ImageView>(R.id.ivImage)
        ivImage.setImageResource(question.image)

        val tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        tvOptionOne.text = question.optionOne
        val tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        tvOptionTwo.text = question.optionTwo
        val tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        tvOptionThree.text = question.optionThree
        val tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
        tvOptionFour.text = question.optionFour

    }
}