package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CarOptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_options)

        val buttons = listOf(
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button13),
            findViewById<Button>(R.id.button15),
            findViewById<Button>(R.id.button16)
        )

        for (button in buttons) {
            button.setOnClickListener {
                val intent = Intent(this, ReservarActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
