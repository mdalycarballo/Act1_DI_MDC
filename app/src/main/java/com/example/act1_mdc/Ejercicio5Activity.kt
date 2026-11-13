package com.example.act1_mdc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Ejercicio5Activity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var primerNumero = 0.0
    private var operacion = ""
    private var esNuevaEntrada = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        tvDisplay = findViewById(R.id.tvDisplay)
        findViewById<FloatingActionButton>(R.id.fabVolver).setOnClickListener { finish() }

        val numButtons = listOf(
            R.id.btn0 to "0", R.id.btn1 to "1", R.id.btn2 to "2",
            R.id.btn3 to "3", R.id.btn4 to "4", R.id.btn5 to "5",
            R.id.btn6 to "6", R.id.btn7 to "7", R.id.btn8 to "8",
            R.id.btn9 to "9", R.id.btnDot to "."
        )

        for ((id, valor) in numButtons) {
            findViewById<Button>(id).setOnClickListener { agregarNumero(valor) }
        }

        findViewById<Button>(R.id.btnAdd).setOnClickListener { setOperacion("+") }
        findViewById<Button>(R.id.btnSub).setOnClickListener { setOperacion("-") }
        findViewById<Button>(R.id.btnMul).setOnClickListener { setOperacion("*") }
        findViewById<Button>(R.id.btnDiv).setOnClickListener { setOperacion("/") }

        findViewById<Button>(R.id.btnClear).setOnClickListener { resetear() }
        findViewById<Button>(R.id.btnEqual).setOnClickListener { calcular() }
    }

    private fun agregarNumero(valor: String) {
        if (esNuevaEntrada) {
            tvDisplay.text = if (valor == ".") "0." else valor
            esNuevaEntrada = false
        } else {
            if (valor == "." && tvDisplay.text.contains(".")) return
            tvDisplay.append(valor)
        }
    }

    private fun setOperacion(op: String) {
        primerNumero = tvDisplay.text.toString().toDoubleOrNull() ?: 0.0
        operacion = op
        esNuevaEntrada = true
    }

    private fun calcular() {
        if (operacion.isEmpty()) return
        val segundoNumero = tvDisplay.text.toString().toDoubleOrNull() ?: 0.0
        val resultado = when (operacion) {
            "+" -> primerNumero + segundoNumero
            "-" -> primerNumero - segundoNumero
            "*" -> primerNumero * segundoNumero
            "/" -> if (segundoNumero != 0.0) primerNumero / segundoNumero else "Error"
            else -> 0.0
        }

        tvDisplay.text = if (resultado is Double && resultado % 1.0 == 0.0) {
            resultado.toLong().toString()
        } else {
            resultado.toString()
        }
        operacion = ""
        esNuevaEntrada = true
    }

    private fun resetear() {
        tvDisplay.text = "0"
        primerNumero = 0.0
        operacion = ""
        esNuevaEntrada = true
    }
}