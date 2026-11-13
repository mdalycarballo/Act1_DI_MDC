package com.example.act1_mdc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnEjercicio1).setOnClickListener {
            startActivity(Intent(this, Ejercicio1Activity::class.java))
        }

        findViewById<Button>(R.id.btnEjercicio2).setOnClickListener {
            startActivity(Intent(this, Ejercicio2_1Activity::class.java))
        }

        findViewById<Button>(R.id.btnEjercicio3).setOnClickListener {
            startActivity(Intent(this, Ejercicio3_1Activity::class.java))
        }

        findViewById<Button>(R.id.btnEjercicio4).setOnClickListener {
            startActivity(Intent(this, Ejercicio4Activity::class.java))
        }

        findViewById<Button>(R.id.btnEjercicio5).setOnClickListener {
            startActivity(Intent(this, Ejercicio5Activity::class.java))
        }

        findViewById<Button>(R.id.btnEjercicio6).setOnClickListener {
            startActivity(Intent(this, Ejercicio6Activity::class.java))
        }
    }
}