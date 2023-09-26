package com.example.icebreaker_class_f23

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.icebreaker_class_f23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "IcebreakerAndroidF23Tag"

    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnGetQuestion.setOnClickListener {// Container for actions when getQuestion is pressed

            Log.d(TAG, "Get question button was pressed")
            binding.txtAnswer.setText("Button was Clicked")
            getQuestionsFromFirebase()

        }

        binding.btnSubmit.setOnClickListener {// Container for actions when submit is pressed

            Log.d(TAG, "Submit button was pressed")

            val firstName = binding.txtFirstName
            val lastName = binding.txtLastName
            val prefName = binding.prefName
            val answer = binding.txtAnswer
            Log.d(TAG, "Entered info is ${firstName.text}, ${lastName.text}, ${prefName.text}, ${answer.text}")

            binding.txtAnswer.setText("${firstName.text}!")
            firstName.setText("")
        }



    }

    override fun onDestroy() {

        super.onDestroy()

    }

    private fun getQuestionsFromFirebase() {

        Log.d(TAG, "Fetching questions from database...")
        binding.txtAnswer.setText("Doing database stuff")

    }
}