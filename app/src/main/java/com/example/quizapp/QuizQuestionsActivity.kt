package com.example.quizapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        val tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        val tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        val tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        val tvOptionFour = findViewById<TextView>(R.id.tv_option_four)

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)


    }

    private fun setQuestion() {
        //mQuestionsList =1

        val question = mQuestionsList!!.get(mCurrentPosition - 1)

        defaultOptionsView()

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = mCurrentPosition

        val tvProgress = findViewById<TextView>(R.id.tvProgress)
        tvProgress.text = "${mCurrentPosition}/" + progressBar.max

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

    @SuppressLint("Range")
    private fun defaultOptionsView() {
        val tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        val tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        val tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        val tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this, R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        val tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        val tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        val tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        val tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tvOptionOne, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tvOptionTwo, 2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tvOptionThree, 3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tvOptionFour, 4)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#FF000000"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this, R.drawable.selected_option_border_bg
        )
    }
}