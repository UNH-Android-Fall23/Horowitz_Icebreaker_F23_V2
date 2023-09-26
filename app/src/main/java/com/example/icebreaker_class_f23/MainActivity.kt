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

        binding.btnGetQuestion.setOnClickListener {

            Log.d(TAG, "Get question button was pressed")
            binding.txtAnswer.setText("Button was Clicked")

        }



    }

    override fun onDestroy() {

        super.onDestroy()

    }
}