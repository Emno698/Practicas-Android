package com.example.distancia_puntos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val etX1 = findViewById<EditText>(R.id.etX1)
        val etY1 = findViewById<EditText>(R.id.etY1)
        val etX2 = findViewById<EditText>(R.id.etX2)
        val etY2 = findViewById<EditText>(R.id.etY2)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val tvmedia = findViewById<TextView>(R.id.tvmedia)

        btnCalcular.setOnClickListener {

            val x1 = etX1.text.toString().toDouble()
            val y1 = etY1.text.toString().toDouble()
            val x2 = etX2.text.toString().toDouble()
            val y2 = etY2.text.toString().toDouble()

            val distancia = sqrt(
                (x2 - x1).pow(2) +
                        (y2 - y1).pow(2)
            )

            val puntoMedioX = (x1 + x2) / 2
            val puntoMedioY = (y1 + y2) / 2

            tvResultado.text = "Distancia: %.2f".format(distancia)
            tvmedia.text = "Media: %.2f".format(puntoMedioY, puntoMedioX)

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}