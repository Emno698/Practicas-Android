package com.example.calificaciones

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val cal1 = findViewById<EditText>(R.id.etCal1)
        val cal2 = findViewById<EditText>(R.id.etCal2)
        val cal3 = findViewById<EditText>(R.id.etCal3)

        val resu = findViewById<TextView>(R.id.tvResultado)
        val btnPro = findViewById<Button>(R.id.btnPromedio)

        val nom = findViewById<EditText>(R.id.etNombre)
        val matr = findViewById<EditText>(R.id.etMatricula)

        btnPro.setOnClickListener {

            val c1 = cal1.text.toString().toDouble()
            val c2 = cal2.text.toString().toDouble()
            val c3 = cal3.text.toString().toDouble()

            val nombre = nom.text.toString()
            val matricula = matr.text.toString()

            val pro = (c1 + c2 + c3) / 3

            resu.text =
                """
        Alumno: $nombre
        Matrícula: $matricula
        
        Promedio: %.2f
        """.trimIndent().format(pro)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}