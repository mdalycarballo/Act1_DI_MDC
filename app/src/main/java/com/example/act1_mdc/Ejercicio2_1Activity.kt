package com.example.act1_mdc

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Ejercicio2_1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2_1)

        val btnNavegar = findViewById<Button>(R.id.button)
        val fabVolver = findViewById<Button>(R.id.btnAtras)

        // Botón flotante para volver al menú principal
        fabVolver.setOnClickListener {
            finish()
        }

        btnNavegar.setOnClickListener {

            // 1. Crear el Intent para ir a Ejercicio2DestinoActivity
            val intent = Intent(this, Ejercicio2DestinoActivity::class.java)

            // 2. Crear el PendingIntent que encapsula el Intent anterior
            val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, flags)

            // 3. Usar Handler con Looper principal para retrasar la ejecución 10 segundos (10000 ms)
            Handler(Looper.getMainLooper()).postDelayed({
                try {
                    // Lanzar la Activity usando el PendingIntent
                    pendingIntent.send()
                    finish() // Opcional: cierra la pantalla actual al cambiar
                } catch (e: PendingIntent.CanceledException) {
                    e.printStackTrace()
                }
            }, 10000)

            Toast.makeText(this, "Temporizador iniciado (10s)", Toast.LENGTH_SHORT).show()
        }
    }
}