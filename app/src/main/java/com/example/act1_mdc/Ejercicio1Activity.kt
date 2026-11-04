package com.example.act1_mdc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Ejercicio1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btnAbrirUrl = findViewById<Button>(R.id.btnAbrirUrl)
        val fabVolver = findViewById<Button>(R.id.btnAtras)

        // Acción para volver al menú principal
        fabVolver.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a MainActivity
        }

        btnAbrirUrl.setOnClickListener {
            var urlText = etUrl.text.toString().trim()

            // Si el usuario no escribe el protocolo, lo añadimos
            if (urlText.isNotEmpty() && !urlText.startsWith("http://") && !urlText.startsWith("https://")) {
                urlText = "https://$urlText"
            }

            // Comprueba que no esté vacío y que sea una URL válida[cite: 1]
            if (urlText.isNotEmpty() && URLUtil.isValidUrl(urlText)) {
                // Intent implícito para abrir el navegador del sistema[cite: 1]
                val intentWeb = Intent(Intent.ACTION_VIEW, Uri.parse(urlText))
                startActivity(intentWeb)
            } else {
                // Notificación mediante Toast[cite: 1]
                Toast.makeText(this, "Por favor, introduzca una URL válida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}