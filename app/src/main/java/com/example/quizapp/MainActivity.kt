package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val etName = findViewById<androidx.appcompat.widget.AppCompatEditText>(R.id.et_name)
        btnStart.setOnClickListener {
            if(etName.text.toString().isEmpty()){
                Toast.makeText(this,
                    "Please enter your name", Toast.LENGTH_SHORT).show()
            } else{
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

    }
}