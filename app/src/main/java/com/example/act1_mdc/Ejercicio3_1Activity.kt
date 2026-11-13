package com.example.act1_mdc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Ejercicio3_1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3_1)

        val btnP1 = findViewById<Button>(R.id.btnPantalla1)
        val btnP2 = findViewById<Button>(R.id.btnPantalla2)
        val btnP3 = findViewById<Button>(R.id.btnPantalla3)
        val fabVolver = findViewById<FloatingActionButton>(R.id.fabVolver)

        fabVolver.setOnClickListener { finish() }

        btnP1.setOnClickListener {
            startActivity(Intent(this, Ejercicio3_2Activity::class.java))
        }

        btnP2.setOnClickListener {
            startActivity(Intent(this, Ejercicio3_3Activity::class.java))
        }

        btnP3.setOnClickListener {
            startActivity(Intent(this, Ejercicio3_4Activity::class.java))
        }
    }
}