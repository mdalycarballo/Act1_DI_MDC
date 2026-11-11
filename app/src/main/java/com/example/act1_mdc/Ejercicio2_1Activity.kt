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

class Ejercicio2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2_1)

        val btnNavegar = findViewById<Button>(R.id.btnNavegarRetrasado)
        val tvEstado = findViewById<TextView>(R.id.tvEstado)
        val fabVolver = findViewById<FloatingActionButton>(R.id.fabVolver)

        // Botón flotante para regresar al menú principal
        fabVolver.setOnClickListener {
            finish()
        }

        btnNavegar.setOnClickListener {
            btnNavegar.isEnabled = false // Desactiva el botón para evitar múltiples pulsaciones
            tvEstado.text = "Iniciando cuenta atrás de 10 segundos..."

            // 1. Prepara el Intent para navegar a la pantalla de destino
            val intent = Intent(this, Ejercicio2DestinoActivity::class.java)

            // 2. Crea el PendingIntent requerido por el enunciado
            val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, flags)

            // 3. Usa Handler con postDelayed a 10.000 ms (10 segundos)
            Handler(Looper.getMainLooper()).postDelayed({
                try {
                    // Lanza la navegación mediante el PendingIntent
                    pendingIntent.send()
                    finish()
                } catch (e: PendingIntent.CanceledException) {
                    e.printStackTrace()
                }
            }, 10000)

            Toast.makeText(this, "Redirigiendo en 10 segundos...", Toast.LENGTH_SHORT).show()
        }
    }
}