package com.example.act1_mdc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEj1 = findViewById<Button>(R.id.btnEjercicio1)

        btnEj1.setOnClickListener {
            // Navega hacia la pantalla del Ejercicio 1
            val intent = Intent(this, Ejercicio1Activity::class.java)
            startActivity(intent)
        }

        // Los botones de los ejercicios 2 al 6 los conectaremos a medida que crees sus Activity
    }
}