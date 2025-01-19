package com.example.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diceroller.R.id.roll_button
import java.util.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(roll_button)

        // button click karne par ek message show karne ka tareeka :
//        rollButton.setOnClickListener {
//            Toast.makeText(this,"Button clicked!", Toast.LENGTH_SHORT).show()
//        }

        rollButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val resultText : TextView = findViewById(R.id.result_text)

        val randomInteger = Random().nextInt(6)+1   //+1 kiya because it will generate from 0 to 5
        resultText.text = randomInteger.toString()         // resultText.text is setter to show above button
        val drawableResource =  when (randomInteger){   //drawableResource is a variable name
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        val diceImage: ImageView = findViewById(R.id.dice_image)
        diceImage.setImageResource(drawableResource)
    }
}