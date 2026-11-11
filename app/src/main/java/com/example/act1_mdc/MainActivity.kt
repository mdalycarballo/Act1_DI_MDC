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
        val btnEj2 = findViewById<Button>(R.id.btnEjercicio2)

        btnEj1.setOnClickListener {
            val intent = Intent(this, Ejercicio1Activity::class.java)
            startActivity(intent)
        }

        btnEj2.setOnClickListener {
            val intent = Intent(this, Ejercicio2Activity::class.java)
            startActivity(intent)
        }
    }
}