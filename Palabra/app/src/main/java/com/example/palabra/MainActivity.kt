package com.example.palabra

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etPalabra = findViewById<EditText>(R.id.Palabra)
        val btnGuardar = findViewById<Button>(R.id.button)

        btnGuardar.setOnClickListener {

            val texto = etPalabra.text.toString()

            try {
                val archivo = OutputStreamWriter(openFileOutput("archivo.txt", MODE_PRIVATE))
                archivo.write(texto)
                archivo.flush()
                archivo.close()

                Toast.makeText(this, "Guardado correctamente", Toast.LENGTH_SHORT).show()

            } catch (e: IOException) {
                Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show()
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}