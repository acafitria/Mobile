package com.example.dicerolller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Tandiandroidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }

        rollDice()
    }


    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val dice2 = Dice (6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView2)
        val diceImage2: ImageView = findViewById(R.id.imageView3)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)

        //Cek nilai data beruntung
        cekdadu(diceRoll, diceRoll2)


        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage.contentDescription = diceRoll.toString()
    }

    private fun cekdadu (dadu1: Int,dadu2:Int) {
        if(dadu1 == dadu2) {
            Toast.makeText(this, "Anda Beruntung", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "Anda Belum Beruntung", Toast.LENGTH_SHORT).show()
        }
    }
}

class Dice (val numSides :Int){

    fun roll (): Int{
        return (1..numSides). random()
    }
}

