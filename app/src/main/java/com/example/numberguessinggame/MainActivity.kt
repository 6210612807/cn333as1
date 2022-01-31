package com.example.numberguessinggame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var imageViewReset: ImageView
    lateinit var imageViewCheck: ImageView
    lateinit var textViewNumber: ImageView

    var random: Int = Random.nextInt(1, 1000)
    var Points = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        imageViewCheck =  findViewById(R.id.imageViewCheck)
        imageViewReset =  findViewById(R.id.imageViewReset)
        val textViewNumber = findViewById<TextView>(R.id.textViewNumber)
        textView.text = "Please enter your guess"


        imageViewCheck.setOnClickListener{

            val number: Int = editText.text.toString().toInt()

            if (number < random){
                Points ++
                textView.text = "Wrong, your number is lower"
                editText.text.clear()
            } else if (number > random) {
                Points ++
                textView.text ="Wrong, your number is higher"
                editText.text.clear()
            } else{

                textView.text ="YOU WIN!!, your number is right"
                editText.text.clear()
            }
            textViewNumber.text= "Guess number : $Points"


        }

        imageViewReset.setOnClickListener{

            reset()

        }

    }
    fun reset() {
        val textViewNumber = findViewById<TextView>(R.id.textViewNumber)
        random = Random.nextInt(1, 1000)
        textView.text = "Please enter your guess:"
        Points = 0
        textViewNumber.text = "Guess number : $Points"
        editText.text.clear()
    }

}