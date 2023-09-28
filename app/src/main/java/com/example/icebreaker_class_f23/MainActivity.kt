package com.example.icebreaker_class_f23

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.icebreaker_class_f23.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val TAG = "IcebreakerAndroidF23Tag"
    private val db = Firebase.firestore
    private var questionBank: MutableList<Questions> = arrayListOf()

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setContentView(R.layout.activity_main)
        Log.d(TAG, "test")
        binding.btnGetQuestion.setOnClickListener {// Container for actions when getQuestion is pressed

            Log.d(TAG, "Get question button was pressed")
            // getQuestionsFromFirebase()

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

        db.collection("questions")
            .get()
            .addOnSuccessListener{documents ->
                questionBank = mutableListOf()

                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener{ exception ->
                Log.w(TAG, "Error getting documents", exception)
            }

    }
}