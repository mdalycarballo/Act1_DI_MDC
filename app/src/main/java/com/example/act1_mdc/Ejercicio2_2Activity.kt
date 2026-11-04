package com.example.act1_mdc

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Ejercicio2DestinoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2_2)

        val fabVolver = findViewById<Button>(R.id.btnAtras)

        // Al pulsar atrás vuelve al menú de actividades
        fabVolver.setOnClickListener {
            finish()
        }
    }
}