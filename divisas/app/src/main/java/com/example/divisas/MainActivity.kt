package com.example.divisas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val cantidad = findViewById<EditText>(R.id.Cantidad)
        val dolar = findViewById<EditText>(R.id.Dolar)
        val euro = findViewById<EditText>(R.id.Euro)
        val yen = findViewById<EditText>(R.id.Yen)
        val btnConvertir = findViewById<Button>(R.id.button)

        btnConvertir.setOnClickListener {

            val valor = cantidad.text.toString().toDouble()

            val converDol = valor / 19.8
            val converEuro = valor / 21.3
            val converYen = valor / 16.5

            dolar.setText("%.2f".format(converDol))
            euro.setText("%.2f".format(converEuro))
            yen.setText("%.2f".format(converYen))
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}