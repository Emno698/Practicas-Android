package com.example.formulariocurso

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.DatePickerDialog
import android.widget.Button
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnFecha = findViewById<Button>(R.id.btnFecha)
        val tvFecha = findViewById<TextView>(R.id.tvFecha)

        btnFecha.setOnClickListener {

            val calendario = Calendar.getInstance()

            val año = calendario.get(Calendar.YEAR)
            val mes = calendario.get(Calendar.MONTH)
            val dia = calendario.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->

                    val fecha = "$dayOfMonth/${month + 1}/$year"

                    tvFecha.text = "Fecha de nacimiento: $fecha"
                },
                año,
                mes,
                dia
            )

            datePicker.show()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}