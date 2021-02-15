package com.example.guess_de_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue = 0
    var maxValue = 0
    var num: Int = 0
    var won = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView= findViewById(R.id.gassings)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.gussed)

        generate.setOnClickListener{
            num = Random.nextInt(minValue, maxValue)
           guessings.setText(num.toString())
           generate.visibility = View.VISIBLE
            guessed.visibility= View.VISIBLE
        }

        up.setOnClickListener {
            minValue = num
            if(checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else{
                guessings.setText("No puede ser :( me ganaste")
            }
        }

        down.setOnClickListener {
            minValue = num
            if(checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessings.setText(num.toString())
            } else{
                guessings.setText("No puede ser :( me ganaste")
            }
        }

        guessed.setOnClickListener {
            if(!won){
                guessings.setText("Adivine, tu numero es el "+ num)
                guessed.setText("Play again")
                won = true
            }else{
                generate.visibility= View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.setText("Guessed")
                guessed.visibility = View.GONE
                resetValue()
            }
        }

    }

    fun resetValue(){
        minValue =0
        maxValue =100
        num= 0
        won= false

    }

   fun checkingLimits(): Boolean{
       return minValue != maxValue
   }

}