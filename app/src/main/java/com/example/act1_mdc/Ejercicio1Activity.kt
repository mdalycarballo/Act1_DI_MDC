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

        fabVolver.setOnClickListener {
            finish()
        }

        btnAbrirUrl.setOnClickListener {
            var urlText = etUrl.text.toString().trim()

            if (urlText.isNotEmpty() && !urlText.startsWith("http://") && !urlText.startsWith("https://")) {
                urlText = "https://$urlText.com"
            }

            if (urlText.isNotEmpty() && URLUtil.isValidUrl(urlText)) {
                val intentWeb = Intent(Intent.ACTION_VIEW, Uri.parse(urlText))
                startActivity(intentWeb)
            } else {
                Toast.makeText(this, "Ponga una url valida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}