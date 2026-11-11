package com.example.act1_mdc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Ejercicio2DestinoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2_2)

        val fabVolver = findViewById<FloatingActionButton>(R.id.fabVolver)

        fabVolver.setOnClickListener {
            finish()
        }
    }
}